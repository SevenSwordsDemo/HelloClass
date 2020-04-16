package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Service.ApplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    ApplyService applyService;

    //获取申请纪录
    @RequestMapping(value = "/getApply",method = RequestMethod.GET)
    public CommonResult getApply()
    {
        return applyService.getApply();
    }
}
