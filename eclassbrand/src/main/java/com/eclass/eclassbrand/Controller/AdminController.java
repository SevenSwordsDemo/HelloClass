package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.Service.AdminService;
import com.eclass.eclassbrand.Service.ApplyService;
import com.eclass.eclassbrand.Service.ScheduleService;
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

}