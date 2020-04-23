package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.Service.StudentService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = {"/student"})
public class StudentController {

    @Resource
    StudentService studentService;

    //申请教室
    @RequestMapping(value = "/apply")
    public CommonResult setApply(@RequestBody Apply apply)
    {
        return studentService.saveApplyRecord(apply);
    }

    //查看预约记录
    @JsonView({Apply.SimpleView.class})
    @RequestMapping(value = "/viewStudentApply")
    public CommonResult viewApply(int sid)
    {
        return studentService.getRecord(sid);
    }

    private void sendResponse(HttpServletResponse response, String responseText)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(responseText);
    }

}
