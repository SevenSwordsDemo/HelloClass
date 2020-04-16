package com.eclass.eclassbrand.Controller;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public CommonResult loginCheck(LoginCommand loginCommand)
	{
		return loginService.loginCheck(loginCommand);
	}

}
