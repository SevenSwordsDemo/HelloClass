package com.eclass.eclassbrand.Controller;


import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.DAO.CourseDAO;
import com.eclass.eclassbrand.DAO.MondayDAO;
import com.eclass.eclassbrand.DAO.TeacherDAO;
import com.eclass.eclassbrand.Factory.FactoryOfDAOOfDay;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.POJO.DayOfWeek;
import com.eclass.eclassbrand.POJO.Monday;
import com.eclass.eclassbrand.Service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
    @Resource MondayDAO mondayDAO;
    @Resource
    TeacherDAO teacherDAO;
    @Resource
    CourseDAO courseDAO;
    @Resource
    ApplyDAO applyDAO;

    @Resource
    private FactoryOfDAOOfDay factoryOfDAOOfDay;
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Page<Apply> test(int page,int size)
    {
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Apply> a=applyDAO.findByState("待审核",pageRequest);
        return a;
    }

    @RequestMapping("addApply")
    public CommonResult addApply()
    {
        return testService.addAplly();
    }

    @RequestMapping("addClassroom")
    public CommonResult addClassroom()
    {
        return testService.addClassroom();
    }

    @RequestMapping("/getThursday")
    public Monday getThursday()
    {
        return testService.getMonday();
    }
}
