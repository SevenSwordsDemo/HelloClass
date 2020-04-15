package com.eclass.eclassbrand.Controller;


import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Service.TestService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sample")
public class TestController {

    @Resource
    private TestService testService;
    @RequestMapping("controller")
    public CommonResult sample()
    {
       return testService.sample();
    }
}
