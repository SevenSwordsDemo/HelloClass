package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Modal.Variable;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
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
    @Resource
    SelectedCourseDAO selectedCourseDAO;
    @Resource
    SigninDAO signinDAO;


    //查询签到情况
    public CommonResult viewSignin(String tno,String week,String dayofweek){
        CommonResult result=new CommonResult();
        try {
            List<SelectedCourse> selectedCourses = selectedCourseDAO.findByTno(tno);
            List<Course> courses = new ArrayList<>();
            for(int i=0;i<selectedCourses.size();++i){
                Course course = selectedCourses.get(i).getCourse();
                courses.add(course);
            }
            List<Signin> signinList = new ArrayList<>();
            if(courses.size()>0){
                for(int i=0;i<courses.size();++i){
                    String cno = courses.get(i).getCno();
                    List<Signin> signins = signinDAO.findByCnoAndWeekAndDayOfWeek(cno,week,dayofweek);
                    signinList.addAll(signins);
                }
            }
            if(signinList.size()!=0) {
                result.setMsg("获取签到成功");
                result.setData(signinList);
            }else {
                result.setStatus(500);
                result.setMsg("无记录");
                result.setResult("fail");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("获取签到表失败");
            result.setResult("fail");
        }
        return result;
    }

    //任课查询
    public CommonResult myCourses(String tno,String theday){
        CommonResult result=new CommonResult();
        List<TeachPlan> teachPlanList = new ArrayList<>();
        try {
            switch (theday){
                case "Sunday":
                    List<Sunday> sundayList = sundayDAO.findByTno(tno);
                    if(sundayList.size()!=0) {
                        for(Sunday s:sundayList){
                            TeachPlan t = new TeachPlan(s.getCourse().getCname(),s.getClassroom(),s.getSchedule(),
                                    s.getCourse().getSelectedCourses().size());
                            teachPlanList.add(t);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
                case "Monday":
                    List<Monday> mondayList = mondayDAO.findByTno(tno);
                    if(mondayList.size()!=0) {
                        for(Monday m:mondayList){
                            TeachPlan t = new TeachPlan(m.getCourse().getCname(),m.getClassroom(),m.getSchedule(),
                                    m.getCourse().getSelectedCourses().size());
                            teachPlanList.add(t);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
                case "Tuesday":
                    List<Tuesday> tuesdayList = tuesdayDAO.findByTno(tno);
                    if(tuesdayList.size()!=0) {
                        for(Tuesday t:tuesdayList){
                            TeachPlan tp = new TeachPlan(t.getCourse().getCname(),t.getClassroom(),t.getSchedule(),
                                    t.getCourse().getSelectedCourses().size());
                            teachPlanList.add(tp);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
                case "Wednesday":
                    List<Wednesday> wednesdayList = wednesdayDAO.findByTno(tno);
                    if(wednesdayList.size()!=0) {
                        for(Wednesday w:wednesdayList){
                            TeachPlan t = new TeachPlan(w.getCourse().getCname(),w.getClassroom(),w.getSchedule(),
                                    w.getCourse().getSelectedCourses().size());
                            teachPlanList.add(t);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
                case "Thursday":
                    List<Thursday> thursdayList = thursdayDAO.findByTno(tno);
                    if(thursdayList.size()!=0) {
                        for(Thursday t:thursdayList){
                            TeachPlan tp = new TeachPlan(t.getCourse().getCname(),t.getClassroom(),t.getSchedule(),
                                    t.getCourse().getSelectedCourses().size());
                            teachPlanList.add(tp);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
                case "Friday":
                    List<Friday> fridayList = fridayDAO.findByTno(tno);
                    if(fridayList.size()!=0) {
                        for(Friday f:fridayList){
                            TeachPlan tp = new TeachPlan(f.getCourse().getCname(),f.getClassroom(),f.getSchedule(),
                                    f.getCourse().getSelectedCourses().size());
                            teachPlanList.add(tp);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
                case "Saturday":
                    List<Saturday> saturdayList = saturdayDAO.findByTno(tno);
                    if(saturdayList.size()!=0) {
                        for(Saturday s:saturdayList){
                            TeachPlan tp = new TeachPlan(s.getCourse().getCname(),s.getClassroom(),s.getSchedule(),
                                    s.getCourse().getSelectedCourses().size());
                            teachPlanList.add(tp);
                        }
                        result.setMsg("获取任课成功");
                        result.setData(teachPlanList);
                    }
                    break;
            }
            if(result.getMsg()!="获取任课成功"){
                result.setStatus(200);
                result.setMsg("无任课");
                result.setResult("fail");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("获取任课失败");
            result.setResult("fail");
        }
        return result;
    }

    //查看周一课程安排
    public CommonResult findMonday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期一";
        result = mergeRecord(schedule);
        return  result;
    }
    //查看周二课程安排
    public CommonResult findTuesday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期二";
        result = mergeRecord(schedule);
        return  result;
    }
    //查看周三课程安排
    public CommonResult findWednesday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期三";
        result = mergeRecord(schedule);
        return  result;
    }
    //查看周四课程安排
    public CommonResult findThursday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期四";
        result = mergeRecord(schedule);
        return  result;
    }
    //查看周五课程安排
    public CommonResult findFriday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期五";
        result = mergeRecord(schedule);
        return  result;
    }
    //查看周六课程安排
    public CommonResult findSaturday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期六";
        result = mergeRecord(schedule);
        return  result;
    }
    //查看周日课程安排
    public CommonResult findSunday(){
        CommonResult result=new CommonResult();
        String schedule = "第"+Variable.getWeek()+"周"+"星期日";
        result = mergeRecord(schedule);
        return  result;
    }

    public CommonResult  mergeRecord(String schedule){
        CommonResult result=new CommonResult();
        List<ClassroomPlan> classroomPlans = new ArrayList<>();
        try {
            List<Monday> mondayList = mondayDAO.findAll();
            List<Apply> applies = applyDAO.findByScheduleAndState(schedule,"通过");
            if(mondayList.size()!=0 || applies.size()!=0) {
                for(Monday m:mondayList){
                    ClassroomPlan c = new ClassroomPlan(m.getClassroom(),m.getSchedule(),"已预约使用",m.getTeacher().getName());
                    classroomPlans.add(c);
                }
                for(Apply a:applies){
                    ClassroomPlan c = new ClassroomPlan(a.getClassroom(),a.getSchedule(),"已预约使用",a.getStudent().getName());
                }
                result.setMsg("获取教室安排成功");
                result.setData(classroomPlans);
            }else {
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

    //按教室搜索周一安排
    public List<Monday> findByClassroom1(String classroom){
        return mondayDAO.findByClassroom(classroom);
    }
    //按教室搜索周二安排
    public List<Tuesday> findByClassroom2(String classroom){
        return tuesdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周三安排
    public List<Wednesday> findByClassroom3(String classroom){
        return wednesdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周四安排
    public List<Thursday> findByClassroom4(String classroom){
        return thursdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周五安排
    public List<Friday> findByClassroom5(String classroom){
        return fridayDAO.findByClassroom(classroom);
    }
    //按教室搜索周六安排
    public List<Saturday> findByClassroom6(String classroom){
        return saturdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周日安排
    public List<Sunday> findByClassroom7(String classroom){
        return sundayDAO.findByClassroom(classroom);
    }
}
