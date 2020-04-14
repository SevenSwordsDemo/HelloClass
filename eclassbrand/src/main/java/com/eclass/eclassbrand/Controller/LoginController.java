package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.POJO.Student;
import com.eclass.eclassbrand.POJO.Teacher;
import com.eclass.eclassbrand.Service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {
	@Resource
	private LoginService loginService;

	//	登陆页面
	@RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
	public ModelAndView loginPage(){
		return new ModelAndView("login");
	}

	//	登陆验证
	@RequestMapping(value = {"/loginCheck"},method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response, LoginCommand loginCommand)
			throws Exception {
		if(loginCommand.getRole()=="0"){
			Teacher t = loginService.tLoginCheck(loginCommand.getUserName(), loginCommand.getPassword());
			if (t != null) {
				request.getSession().setAttribute("teacher", t);
				return new ModelAndView("teacherpage");
			}else {
				return new ModelAndView("login", "error", "用户名或密码错误。");
			}
		}
		else{
			Student s = loginService.sLoginCheck(loginCommand.getUserName(), loginCommand.getPassword());
			if (s != null) {
				request.getSession().setAttribute("student", s);
				return new ModelAndView("teacherpage");
			}else {
				return new ModelAndView("login", "error", "用户名或密码错误。");
			}

		}
	}

	private void sendResponse(HttpServletResponse response, String responseText)
			throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(responseText);
	}

}
