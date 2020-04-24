package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.POJO.ClassroomPlan;
import com.eclass.eclassbrand.ParamModal.GetScheduleOfClassParam;
import com.eclass.eclassbrand.ParamModal.GetScheduleParam;
import com.eclass.eclassbrand.ParamModal.GetStudentsParam;
import com.eclass.eclassbrand.Service.AdminService;
import com.eclass.eclassbrand.Service.ApplyService;
import com.eclass.eclassbrand.Service.ScheduleService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    ApplyService applyService;
    @Resource
    ScheduleService scheduleService;
    @Resource
    AdminService adminService;

    //获取申请纪录
    @RequestMapping(value = "/getApply",method = RequestMethod.GET)

    public CommonResult getApply(Integer page,Integer size)
    {
        return applyService.getApply(page,size);
    }

    //获取楼层信息
    @RequestMapping(value = "/getFloor",method=RequestMethod.GET)
    public CommonResult getFloor()
    {
        return scheduleService.getFloor();
    }

    //根据楼层获取教室列表
    @RequestMapping(value = "/getClassroom",method = RequestMethod.GET)
    public CommonResult getClassroom(String floor)
    {
        return scheduleService.getClassroom(floor);
    }


    //获取管理员列表
    @RequestMapping(value = "/getAdminList",method = RequestMethod.GET)
    public CommonResult getAdminList()
    {
        return adminService.getAdminList();
    }

    //增加管理员
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public CommonResult addAdmin(Administrator administrator)
    {
        return adminService.addAdmin(administrator);
    }

    //删除管理员
    @RequestMapping(value="/delAdmin",method = RequestMethod.GET)
     public CommonResult delAdmin(String account)
    {
        return adminService.delAdmin(account);
    }

    //按楼名获取当日日程安排
    @RequestMapping(value = "/getSchedule",method = RequestMethod.POST)
    @JsonView(value = ClassroomPlan.AdminView.class)
    public CommonResult getSchedule(GetScheduleParam getScheduleParam)
    {
        Integer week=getScheduleParam.getWeek();
        String theday=getScheduleParam.getTheday();
        String build=getScheduleParam.getBuild();
        Integer page=getScheduleParam.getPage();
        Integer size=getScheduleParam.getSize();
        return scheduleService.findByBuild(week,theday,build,page,size);
    }

    //申请处理
    @RequestMapping(value = "/apply/{operate}",method = RequestMethod.GET)
    public CommonResult handleApply(@PathVariable("operate")String operate,int id)
    {
        return adminService.handleApply(operate,id);
    }


    //获取某教室当天日程
    @RequestMapping(value = "/getScheduleOfClass",method = RequestMethod.POST)
    @JsonView(value = ClassroomPlan.AdminView.class)
    public CommonResult getScheduleOfClass(GetScheduleOfClassParam getScheduleOfClassParam)
    {
        Integer week=getScheduleOfClassParam.getWeek();
        String dayOfWeek=getScheduleOfClassParam.getDayOfWeek();
        String classroom=getScheduleOfClassParam.getClassroom();
        return scheduleService.getScheduleOfDayOfClass(week,dayOfWeek,classroom);
    }

    //获取所有学生信息
    @RequestMapping(value = "/getAllStudent",method = RequestMethod.GET)
    public CommonResult getAllStudent(Integer page,Integer size)
    {
        return adminService.getAllStudent(page,size);
    }

    //获取学院列表
    @RequestMapping(value="/getAcademy",method = RequestMethod.GET)
    public CommonResult getAcademy()
    {
        return adminService.getAcademy();
    }

    //获取学院班级
    @RequestMapping(value="/getClassesOfAcademy",method = RequestMethod.GET)
    public CommonResult getClassesOfAcademy(String academy)
    {
        return adminService.getClassesAcademy(academy);
    }

    //分页获取某学院学生信息
    @RequestMapping(value = "/getStudentsByAcademy",method = RequestMethod.POST)
    public CommonResult getStudentsByAcademy(GetStudentsParam getStudentsParam)
    {
        Integer page=getStudentsParam.getPage();
        Integer size=getStudentsParam.getSize();
        String academy=getStudentsParam.getAcademy();
        return adminService.getStudentsByAcademy(page,size,academy);
    }

    //根据学院班级获取学生信息
    @RequestMapping(value = "/getStudentsOfClasses",method=RequestMethod.GET)
    public CommonResult getStudentsOfClasses(String academy,String classes)
    {
        return adminService.getStudentsOfClass(academy,classes);
    }
}