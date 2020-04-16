package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    TeacherService teacherService;


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
        try {
            switch (theday){
                case "Sunday": List<Sunday> sundayList = sundayDAO.findByTno(tno);
                    if(sundayList.size()!=0){
                        result.setMsg("获取任课成功");
                        result.setData(sundayList);
                    }
                    break;
                case "Monday":List<Monday> mondayList = mondayDAO.findByTno(tno);
                    if(mondayList.size()!=0){
                        if(mondayList.size()!=0){
                            result.setMsg("获取任课成功");
                            result.setData(mondayList);
                        }
                    }
                    break;
                case "Tuesday":List<Tuesday> tuesdayList = tuesdayDAO.findByTno(tno);
                    if(tuesdayList.size()!=0){
                        if(tuesdayList.size()!=0){
                            result.setMsg("获取任课成功");
                            result.setData(tuesdayList);
                        }
                    }
                    break;
                case "Wednesday":List<Wednesday> wednesdayList = wednesdayDAO.findByTno(tno);
                    if(wednesdayList.size()!=0){
                        if(wednesdayList.size()!=0){
                            result.setMsg("获取任课成功");
                            result.setData(wednesdayList);
                        }
                    }
                    break;
                case "Thursday":List<Thursday> thursdayList = thursdayDAO.findByTno(tno);
                    if(thursdayList.size()!=0){
                        if(thursdayList.size()!=0){
                            result.setMsg("获取任课成功");
                            result.setData(thursdayList);
                        }
                    }
                    break;
                case "Friday":List<Friday> fridayList = fridayDAO.findByTno(tno);
                    if(fridayList.size()!=0){
                        if(fridayList.size()!=0){
                            result.setMsg("获取任课成功");
                            result.setData(fridayList);
                        }
                    }
                    break;
                case "Saturday":List<Saturday> saturdayList = saturdayDAO.findByTno(tno);
                    if(saturdayList.size()!=0){
                        if(saturdayList.size()!=0){
                            result.setMsg("获取任课成功");
                            result.setData(saturdayList);
                        }
                    }
                    break;
            }
            if(result.getMsg()!="获取任课成功"){
                result.setStatus(500);
                result.setMsg("获取教室安排失败");
                result.setResult("fail");

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  result;
    }



}
