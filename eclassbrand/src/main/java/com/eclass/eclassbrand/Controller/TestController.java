package com.eclass.eclassbrand.Controller;


import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Service.TestService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
<<<<<<< Updated upstream

    @RequestMapping("controller")
=======
    @RequestMapping(value = "controller",method = RequestMethod.GET)
>>>>>>> Stashed changes
    public CommonResult sample()
    {
       return testService.sample();
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
}
