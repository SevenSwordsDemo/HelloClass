package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Factory.FactoryOfDAOOfDay;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ScheduleService {
    @Resource
    private ClassroomDAO classroomDAO;
    @Resource
    ApplyDAO applyDAO;
   @Resource
   CourseDAO courseDAO;
   @Resource
   TeacherDAO teacherDAO;
    @Resource
    FactoryOfDAOOfDay factoryOfDAOOfDay;

    //获取楼层
    public CommonResult getFloor()
    {
        CommonResult result=new CommonResult();
        List<String> floors=classroomDAO.getFloor("正常");
        if(floors.size()==0)
        {
            result.setMsg("暂无数据");
        }
        else
        {
            result.setMsg("获取楼层信息成功");
            result.setData(floors);
        }
        return result;
    }

    //根据楼层获取教室列表
    public CommonResult getClassroom(String floor)
    {
        CommonResult result=new CommonResult();
        System.out.println("floor:"+floor);

        List<String> roomNumbers=classroomDAO.getClassroomByFloor(floor);

        if(roomNumbers.size()==0)
            result.setMsg("暂无数据");
        else
        {
            result.setMsg("获取教室列表成功");
            result.setData(roomNumbers);
        }
       result.setData(roomNumbers);
        return result;
    }

    //返回当天所有教室日程
    public CommonResult findClassroomPlan(int week,String theday){
       return mergeRecord(week,theday);
    }

   // 合并当天课程安排和学生预约
    private CommonResult mergeRecord(int week,String theday){
        CommonResult result=new CommonResult();
        BasicDAOOfDay basicDAOOfDay = factoryOfDAOOfDay.createDaoOfDay(theday);
        List<ClassroomPlan> classroomPlans = new ArrayList<>();
        HashMap<String,Integer> hashMap=new HashMap<>();
        try {
            List<String> classrooms = basicDAOOfDay.getAllClassroom(week);
            if (classrooms.size() != 0) {
                List<Apply> applies = null;
                for (int i = 0; i < classrooms.size(); i++) {
                    ClassroomPlan classroomPlan = new ClassroomPlan(classrooms.get(i));
                    hashMap.put(classrooms.get(i), i);
                    applies = applyDAO.findByWeekAndDayOfWeekAndClassroomLikeAndState(week, theday, classrooms.get(i), "通过");//所有学生预约
                    if (applies.size() != 0) {
                        for (Apply apply : applies) {
                            Schedule schedule = new Schedule(apply.getStart(), apply.getEnd(), "已预约使用", apply.getStudent().getName(), apply.getReason());
                            classroomPlan.getSchedules().add(schedule);
                        }
                    }
                    classroomPlans.add(classroomPlan);
                }
                List<DayOfWeek> scheduleList = basicDAOOfDay.findAllByOrderByStart(week);//所有课程安排
                if (scheduleList.size() != 0) {
                    for (DayOfWeek day : scheduleList) {
                        int index = hashMap.get(day.getClassroom());
                        String tName = teacherDAO.findByTno(day.getTno()).getName();
                        String cName = courseDAO.findByCno(day.getCno()).getCname();
                        Schedule schedule = new Schedule(day.getStart(), day.getEnd(), "已预约使用", tName, cName);
                        classroomPlans.get(index).getSchedules().add(schedule);
                    }
                }
                if (applies.size() == 0 && scheduleList.size() == 0)
                    result.setMsg("暂无日程");
                result.setData(classroomPlans);
                result.setMsg("获取日程成功");
            } else
                result.setMsg("暂无数据");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setMsg("服务器错误");
            result.setStatus(500);
            result.setResult("fail");
        }
        return result;
    }

    //按时间楼名搜索安排
    public CommonResult findByBuild(int week,String theday,String build,int page,int size){
       return getSchedule(theday,week,build,page,size);
    }

    private CommonResult getSchedule(String dayOfWeek,int week,String build,int page,int size)
    {
        CommonResult result=new CommonResult();
        PageRequest pageRequest=PageRequest.of(page,size);
        try {
            BasicDAOOfDay basicDAOOfDay = factoryOfDAOOfDay.createDaoOfDay(dayOfWeek);
            List<String> classrooms = basicDAOOfDay.getClassroom(build+"%", week,pageRequest).getContent();
            List<ClassroomPlan> classroomPlans = new ArrayList<>();
            HashMap<String, Integer> classroomMap = new HashMap<>();
            if (classrooms.size() != 0) {
                for (int i = 0; i < classrooms.size(); i++) {
                    ClassroomPlan classroomPlan = new ClassroomPlan(classrooms.get(i));
                    System.out.println("Classroom:"+classrooms.get(i));
                    classroomMap.put(classrooms.get(i), i);
                    classroomPlans.add(classroomPlan);
                }
                List<DayOfWeek> scheduleList = basicDAOOfDay.findByClassroomLike(build + "%", week);//所有课程安排
                if (scheduleList.size() != 0) {
                    for (DayOfWeek day : scheduleList) {
                        int index = classroomMap.get(day.getClassroom());
                        String tName=teacherDAO.findByTno(day.getTno()).getName();
                        String cName=courseDAO.findByCno(day.getCno()).getCname();
//                        System.out.println("tName:"+tName);
//                        System.out.println("cName:"+cName);
//                        System.out.println("Start:"+day.getStart());
//                        System.out.println("End:"+day.getEnd());
                        Schedule schedule = new Schedule(day.getStart(), day.getEnd(), "已预约使用",tName, cName);
                        classroomPlans.get(index).getSchedules().add(schedule);
                    }
                }
                List<Apply> applies = applyDAO.findByWeekAndDayOfWeekAndClassroomLikeAndState(week, dayOfWeek, build + "%", "通过");//所有学生预约
                if (applies.size() != 0) {
                    for (Apply apply : applies) {
                        int index = classroomMap.get(apply.getClassroom());
                        Schedule schedule = new Schedule(apply.getStart(), apply.getEnd(), "已预约使用", apply.getStudent().getName(), apply.getReason());
                        classroomPlans.get(index).getSchedules().add(schedule);
                    }
                }

                if (scheduleList.size() == 0 && applies.size() == 0)
                    result.setMsg("暂无日程");
                result.setData(classroomPlans);
                result.setMsg("获取日程成功");
            }
            else
                result.setMsg("暂无数据");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("服务器错误");
            result.setResult("fail");
        }

        return result;
    }

    //获取某教室当天日程
    public CommonResult getScheduleOfDayOfClass(int week,String dayOfWeek,String classroom)
    {
        CommonResult result=new CommonResult();
        try {
            BasicDAOOfDay basicDAOOfDay = factoryOfDAOOfDay.createDaoOfDay(dayOfWeek);
            List<DayOfWeek> dayOfWeeks = basicDAOOfDay.getScheduleOfClass(week, classroom);
            ClassroomPlan classroomPlan = new ClassroomPlan(classroom);
            Pattern pattern=Pattern.compile("[a-zA-Z]\\d+");
            Matcher matcher=pattern.matcher(classroom);
            String classNum="";
            if(matcher.find())
            {
                classNum=matcher.group(0);
                System.out.println("classNum:"+classNum);
            }
            System.out.println("floor:"+classroom.split("[a-zA-Z]")[0]);
            String deviceState = classroomDAO.getDeviceState(classroom.split("[a-zA-Z]")[0],classNum);
            System.out.println("deviceState:"+deviceState);
            classroomPlan.setDeviceState(deviceState);
            if (dayOfWeeks.size() != 0) {
                for (DayOfWeek day : dayOfWeeks) {
                    String tName = teacherDAO.findByTno(day.getTno()).getName();
                    String cName = courseDAO.findByCno(day.getCno()).getCname();
                    Schedule schedule = new Schedule(day.getStart(), day.getEnd(), "已预约使用", tName, cName);
                    classroomPlan.getSchedules().add(schedule);
                }
            }
            List<Apply> applies = applyDAO.findApplyOfDay(week, dayOfWeek, classroom);
            if (applies.size() != 0) {
                for (Apply apply : applies) {
                    Schedule schedule = new Schedule(apply.getStart(), apply.getEnd(), "已预约使用", apply.getStudent().getName(), apply.getReason());
                    classroomPlan.getSchedules().add(schedule);
                }
            }
            result.setMsg("获取日程成功");
            result.setData(classroomPlan);
            if (dayOfWeeks.size() == 0 && applies.size() == 0)
                result.setMsg("暂无日程");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("服务器错误");
            result.setResult("fail");
        }
        return result;
    }
}
