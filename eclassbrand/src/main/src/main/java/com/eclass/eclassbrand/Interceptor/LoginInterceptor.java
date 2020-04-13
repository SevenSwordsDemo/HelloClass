package com.eclass.eclassbrand.Interceptor;

import com.eclass.eclassbrand.POJO.Student;
import com.eclass.eclassbrand.POJO.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        Teacher t = (Teacher) request.getSession().getAttribute("teacher");
        Student s = (Student) request.getSession().getAttribute("student");
        if(t==null || s==null){
            request.setAttribute("error", "请先登录");
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }
}
