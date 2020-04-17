package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Resource
    private ClassroomDAO classroomDAO;
    @Resource
    ApplyDAO applyDAO;
    @Resource
    MondayDAO mondayDAO;
    @Resource
    TuesdayDAO tuesdayDAO;
    @Resource
    WednesdayDAO wednesdayDAO;
    @Resource
    ThursdayDAO thursdayDAO;
    @Resource
    FridayDAO fridayDAO;
    @Resource
    SaturdayDAO saturdayDAO;
    @Resource
    SundayDAO sundayDAO;

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
    //按时间查看教室日程安排
    public CommonResult findClassroomPlan(int week,String theday){
        CommonResult result=new CommonResult();
        result = mergeRecord(week,theday);
        return  result;
    }

    //合并当天课程安排和学生预约
    public CommonResult mergeRecord(int week,String theday){
        CommonResult result=new CommonResult();
        List<ClassroomPlan> classroomPlans = new ArrayList<>();
        try {
            switch (theday){
                case "Sunday": List<Sunday> sundayList = sundayDAO.findAllByOrderByStart();
                    if(sundayList.size()!=0){
                        for(Sunday m:sundayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Monday":List<Monday> mondayList = mondayDAO.findAllByOrderByStart();
                    if(mondayList.size()!=0){
                        for(Monday m:mondayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Tuesday":List<Tuesday> tuesdayList = tuesdayDAO.findAllByOrderByStart();
                    if(tuesdayList.size()!=0){
                        for(Tuesday m:tuesdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Wednesday":List<Wednesday> wednesdayList = wednesdayDAO.findAllByOrderByStart();
                    if(wednesdayList.size()!=0){
                        for(Wednesday m:wednesdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Thursday":List<Thursday> thursdayList = thursdayDAO.findAllByOrderByStart();
                    if(thursdayList.size()!=0){
                        for(Thursday m:thursdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Friday":List<Friday> fridayList = fridayDAO.findAllByOrderByStart();
                    if(fridayList.size()!=0){
                        for(Friday m:fridayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Saturday":List<Saturday> saturdayList = saturdayDAO.findAllByOrderByStart();
                    if(saturdayList.size()!=0){
                        for(Saturday m:saturdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
            }
            //学生安排
            List<Apply> applies = applyDAO.findByWeekAndDayOfWeekAndState(week,theday,"通过");
            System.out.println("ssssssssssssssssssss:"+applies.size());
            if(applies.size()!=0) {
                for(Apply a:applies){
                    ClassroomPlan c = new ClassroomPlan(a.getClassroom(),a.getStart(),a.getEnd(),"已预约使用",a.getStudent().getName());
                    classroomPlans.add(c);
                }
            }
            if(classroomPlans.size()!=0) {
                result.setMsg("获取教室安排成功");
                result.setData(classroomPlans);
            }else{
                result.setStatus(500);
                result.setMsg("当日无记录");
                result.setResult("fail");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("获取教室安排失败");
            result.setResult("fail");
        }
        return result;
    }

    //按时间楼名搜索安排
    public CommonResult findByBuild(int week,String theday,String build){
        CommonResult result=new CommonResult();
        List<ClassroomPlan> classroomPlans = new ArrayList<>();
        try {
            List<Apply> applies = applyDAO.findByWeekAndDayOfWeekAndStateAndClassroomContaining(week,theday,"通过",build);
            if(applies.size()!=0){
                for(Apply a:applies){
                    ClassroomPlan c = new ClassroomPlan(a.getClassroom(),a.getStart(),a.getEnd(),"已预约使用",a.getStudent().getName());
                    classroomPlans.add(c);
                }
            }
            switch (theday){
                case "Sunday": List<Sunday> sundayList = sundayDAO.findByClassroomLike(build);
                    if(sundayList.size()!=0){
                        for(Sunday m:sundayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Monday":List<Monday> mondayList = mondayDAO.findByClassroomLike(build);
                    if(mondayList.size()!=0){
                        for(Monday m:mondayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Tuesday":List<Tuesday> tuesdayList = tuesdayDAO.findByClassroomLike(build);
                    if(tuesdayList.size()!=0){
                        for(Tuesday m:tuesdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Wednesday":List<Wednesday> wednesdayList = wednesdayDAO.findByClassroomLike(build);
                    if(wednesdayList.size()!=0){
                        for(Wednesday m:wednesdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Thursday":List<Thursday> thursdayList = thursdayDAO.findByClassroomLike(build);
                    if(thursdayList.size()!=0){
                        for(Thursday m:thursdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Friday":List<Friday> fridayList = fridayDAO.findByClassroomLike(build);
                    if(fridayList.size()!=0){
                        for(Friday m:fridayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
                case "Saturday":List<Saturday> saturdayList = saturdayDAO.findByClassroomLike(build);
                    if(saturdayList.size()!=0){
                        for(Saturday m:saturdayList){
                            ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getStart(),m.getEnd(),"已预约使用",m.getTeacher().getName());
                            classroomPlans.add(c);
                        }
                    }
                    break;
            }
            if(classroomPlans.size()!=0) {
                result.setMsg("获取教室安排成功");
                result.setData(classroomPlans);
            }else{
                result.setStatus(500);
                result.setMsg("当日无记录");
                result.setResult("fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
