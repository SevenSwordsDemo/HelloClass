package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.POJO.ClassroomPlan;
import com.eclass.eclassbrand.Service.AdminService;
import com.eclass.eclassbrand.Service.ApplyService;
import com.eclass.eclassbrand.Service.ScheduleService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public CommonResult getApply()
    {
        return applyService.getApply();
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
    public CommonResult getSchedule(int week,String theday,String build )
    {
        return scheduleService.findByBuild(week,theday,build);
    }

    //申请处理
    @RequestMapping(value = "/apply/{operate}",method = RequestMethod.GET)
    public CommonResult handleApply(@PathVariable("operate")String operate,int id)
    {
        System.out.println("FHGFHD");
        return adminService.handleApply(operate,id);
    }


    //获取某教室当天日程
    @RequestMapping(value = "/getScheduleOfClass",method = RequestMethod.POST)
    @JsonView(value = ClassroomPlan.AdminView.class)
    public CommonResult getScheduleOfClass(int week,String dayOfWeek,String classroom)
    {
        return scheduleService.getScheduleOfDayOfClass(week,dayOfWeek,classroom);
    }

}