package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public CommonResult viewSignin(String tno,int week,String dayofweek){
        CommonResult result=new CommonResult();
        try {
            List<SigninResult> signinResults = new ArrayList<>();
            List<SelectedCourse> selectedCourses = selectedCourseDAO.findByTno(tno);
            Set<Course> courses = new HashSet<>();
            for(int i=0;i<selectedCourses.size();++i){
                Course course = selectedCourses.get(i).getCourse();
                courses.add(course);
            }
            System.out.println("coursessssssssssss:"+courses.size());
            List<Signin> signinList = new ArrayList<>();
            if(courses.size()>0){
                for(Course c:courses){
                    String cno = c.getCno();
                    int number = selectedCourseDAO.findByCno(cno).size();
                    List<Signin> signins = signinDAO.findByCnoAndWeekAndDayOfWeek(cno,week,dayofweek);
                    List<String> students = new ArrayList<>();
                    for(Signin s: signins){
                        students.add(s.getStudent().getName());
                    }
                    String classroom = returnClassroom(cno,dayofweek);
                    SigninResult signinResult = new SigninResult(c.getCname(),classroom,number-students.size(),students);
                    signinResults.add(signinResult);
                    System.out.println("signinResult:"+signinResult);
                }
            }
            if(signinResults.size()!=0) {
                result.setMsg("获取签到成功");
                result.setData(signinResults);
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
                result.setMsg("获取任课失败");
                result.setResult("fail");

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  result;
    }

    public String returnClassroom(String cno,String dayofweek){
        String classroom = "";
        try {
            switch (dayofweek){
                case "Sunday": List<Sunday> sundayList = sundayDAO.findByCno(cno);
                    if(sundayList.size()!=0){
                        classroom = sundayList.get(0).getClassroom();
                    }
                    break;
                case "Monday":List<Monday> mondayList = mondayDAO.findByCno(cno);
                    if(mondayList.size()!=0){
                        if(mondayList.size()!=0){
                            classroom = mondayList.get(0).getClassroom();
                        }
                    }
                    break;
                case "Tuesday":List<Tuesday> tuesdayList = tuesdayDAO.findByCno(cno);
                    if(tuesdayList.size()!=0){
                        if(tuesdayList.size()!=0){
                            classroom = tuesdayList.get(0).getClassroom();
                        }
                    }
                    break;
                case "Wednesday":List<Wednesday> wednesdayList = wednesdayDAO.findByCno(cno);
                    if(wednesdayList.size()!=0){
                        if(wednesdayList.size()!=0){
                            classroom = wednesdayList.get(0).getClassroom();
                        }
                    }
                    break;
                case "Thursday":List<Thursday> thursdayList = thursdayDAO.findByCno(cno);
                    if(thursdayList.size()!=0){
                        if(thursdayList.size()!=0){
                            classroom = thursdayList.get(0).getClassroom();
                        }
                    }
                    break;
                case "Friday":List<Friday> fridayList = fridayDAO.findByCno(cno);
                    if(fridayList.size()!=0){
                        if(fridayList.size()!=0){
                            classroom = fridayList.get(0).getClassroom();
                        }
                    }
                    break;
                case "Saturday":List<Saturday> saturdayList = saturdayDAO.findByCno(cno);
                    if(saturdayList.size()!=0){
                        if(saturdayList.size()!=0){
                            classroom = saturdayList.get(0).getClassroom();
                        }
                    }
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return classroom;
    }

}
