package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Modal.Variable;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.Service.ApplyService;
import com.eclass.eclassbrand.Service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/teacher"})
public class TeacherController {

    @Resource
    TeacherService teacherService;
    @Resource
    ApplyService applyService;

    //任课查询
    @RequestMapping(value = "teachcourses",method = RequestMethod.POST)
    public CommonResult viewTeacherCourses(String tno)
    {
        CommonResult result = new CommonResult();
        Date date = new Date();
        String theday = getWeekOfDate(date);

        return teacherService.myCourses(tno,theday);
    }

    //签到查询
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public CommonResult viewSignin(String tno,String week,String dayofweek)
    {
        return teacherService.viewSignin(tno,week,dayofweek);
    }


    //根据当前日前返回当天教室情况安排
    @RequestMapping(value = "/theday",method = RequestMethod.GET)
    public CommonResult returnTheDay()
    {
        CommonResult result = new CommonResult();
        Date date = new Date();
        String theday = getWeekOfDate(date);

        switch (theday){
            case "Sunday":result =  teacherService.findSunday();
            break;
            case "Monday":result =  teacherService.findMonday();
            break;
            case "Tuesday":result =  teacherService.findTuesday();
            break;
            case "Wednesday":result = teacherService.findWednesday();
            break;
            case "Thursday":result =  teacherService.findThursday();
            break;
            case "Friday":result =  teacherService.findFriday();
            break;
            case "Saturday":result =  teacherService.findSaturday();
            break;
        }
        return result;
    }
    //查询周一安排
    @RequestMapping(value = "/viewMonday",method = RequestMethod.GET)
    public CommonResult returnMonday()
    {
        return teacherService.findMonday();
    }
    //查询周二安排
    @RequestMapping(value = "/viewTuesday",method = RequestMethod.GET)
    public CommonResult returnTuesday()
    {
        return teacherService.findTuesday();
    }
    //查询周三安排
    @RequestMapping(value = "/viewWednesday",method = RequestMethod.GET)
    public CommonResult returnWednesday()
    {
        return teacherService.findWednesday();
    }
    //查询周四安排
    @RequestMapping(value = "/viewThursday",method = RequestMethod.GET)
    public CommonResult returnThursday()
    {
        return teacherService.findThursday();
    }
    //查询周五安排
    @RequestMapping(value = "/viewFriday",method = RequestMethod.GET)
    public CommonResult returnFriday()
    {
        return teacherService.findFriday();
    }
    //查询周六安排
    @RequestMapping(value = "/viewSaturday",method = RequestMethod.GET)
    public CommonResult returnSaturday()
    {
        return teacherService.findSaturday();
    }
    //查询周日安排
    @RequestMapping(value = "/viewSunday",method = RequestMethod.GET)
    public CommonResult returnSunday()
    {
        return teacherService.findSunday();
    }



    public String getWeekOfDate(Date date) {
        String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }


    private void sendResponse(HttpServletResponse response, String responseText)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(responseText);
    }

}
