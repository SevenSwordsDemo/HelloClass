package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Modal.Variable;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.Service.ApplyService;
import com.eclass.eclassbrand.Service.ScheduleService;
import com.eclass.eclassbrand.Service.TeacherService;
import com.eclass.eclassbrand.Util;
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
    @Resource
    ScheduleService scheduleService;

    //任课查询
    @RequestMapping(value = "teachCourses",method = RequestMethod.POST)
    public CommonResult viewTeacherCourses(String tno,String theday)
    {
        CommonResult result = new CommonResult();
        return teacherService.myCourses(tno,theday);
    }

    //签到查询
    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    public CommonResult viewSignin(String tno,int week,String dayofweek)
    {
        return teacherService.viewSignin(tno,week,dayofweek);
    }


    //根据时间返回当天教室情况安排
    @RequestMapping(value = "/theDayPlans",method = RequestMethod.POST)
    public CommonResult returnTheDay(String week,String theday)
    {
        CommonResult result = new CommonResult();
        result = scheduleService.findClassroomPlan(week,theday);

        return result;
    }

    //根据时间楼名返回教室安排
    @RequestMapping(value = "/theDayPlansByBuild",method = RequestMethod.POST)
    public CommonResult returnTheDayByBuild(int week,String theday,String build)
    {
        CommonResult result = new CommonResult();
        result =  scheduleService.findByBuild(week,theday,build);

        return result;
    }


    private void sendResponse(HttpServletResponse response, String responseText)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(responseText);
    }

}
