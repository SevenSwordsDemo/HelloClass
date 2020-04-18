package com.eclass.eclassbrand.Controller;


import com.eclass.eclassbrand.DAO.CourseDAO;
import com.eclass.eclassbrand.DAO.MondayDAO;
import com.eclass.eclassbrand.DAO.TeacherDAO;
import com.eclass.eclassbrand.Factory.FactoryOfDAOOfDay;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.DayOfWeek;
import com.eclass.eclassbrand.POJO.Monday;
import com.eclass.eclassbrand.Service.TestService;
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
    private FactoryOfDAOOfDay factoryOfDAOOfDay;
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public CommonResult test()
    {
        CommonResult result=new CommonResult();
//        BasicDAOOfDay basicDAOOfDay=factoryOfDAOOfDay.createDaoOfDay("Monday");
//       result.setData(basicDAOOfDay.getClassroom("广知楼%",2));
        List<DayOfWeek> dayOfWeeks=mondayDAO.findAllByClassroom("广知楼A101",2);
        if(dayOfWeeks.size()==0)
        {
            System.out.println("000000000000000");
        }
        else {
            for (DayOfWeek dayOfWeek : dayOfWeeks) {
               // System.out.println("Teacher name:" + dayOfWeek.getTeacher().getName());
                String tName=teacherDAO.findByTno(dayOfWeek.getTno()).getName();
                String cName=courseDAO.findByCno(dayOfWeek.getCno()).getCname();
                System.out.println("tName:"+tName);
                System.out.println("cName:"+cName);
                System.out.println("Type:" + dayOfWeek.getClass());
            }
        }
        result.setData(dayOfWeeks);
       return result;
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
