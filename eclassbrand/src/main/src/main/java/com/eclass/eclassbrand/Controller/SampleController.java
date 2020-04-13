package com.eclass.eclassbrand.Controller;


import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Service.SampleService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Resource
    private SampleService sampleService;
    @RequestMapping("controller")
    public CommonResult sample()
    {
       return sampleService.sample();
    }
}
