package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.POJO.ClassroomPlan;
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
    public CommonResult getApply(int page,int size)
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
    public CommonResult getSchedule(int week,String theday,String build,int page,int size )
    {
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
    public CommonResult getScheduleOfClass(int week,String dayOfWeek,String classroom)
    {
        return scheduleService.getScheduleOfDayOfClass(week,dayOfWeek,classroom);
    }

    //获取所有学生信息
    @RequestMapping(value = "/getAllStudent",method = RequestMethod.GET)
    public CommonResult getAllStudent(int page,int size)
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
    public CommonResult getStudentsByAcademy(int page,int size,String academy)
    {
        return adminService.getStudentsByAcademy(page,size,academy);
    }

    //根据学院班级获取学生信息
    @RequestMapping(value = "/getStudentsOfClasses",method=RequestMethod.GET)
    public CommonResult getStudentsOfClasses(String academy,String classes)
    {
        return adminService.getStudentsOfClass(academy,classes);
    }
}