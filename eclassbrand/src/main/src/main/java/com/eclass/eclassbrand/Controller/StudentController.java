package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.Service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public void setApply(Apply apply)
    {
        studentService.saveApplyRecord(apply);
    }


    private void sendResponse(HttpServletResponse response, String responseText)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(responseText);
    }

}
