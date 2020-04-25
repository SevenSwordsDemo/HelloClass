package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.Controller.LoginCommand;
import com.eclass.eclassbrand.DAO.AdminDAO;
import com.eclass.eclassbrand.DAO.StudentDAO;
import com.eclass.eclassbrand.DAO.TeacherDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.POJO.Student;
import com.eclass.eclassbrand.POJO.Teacher;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    TeacherDAO teacherDAO;
    @Resource
    StudentDAO studentDAO;
    @Resource
    AdminDAO adminDAO;

    public CommonResult loginCheck(LoginCommand loginCommand)
    {
        CommonResult result=new CommonResult();
        String account=loginCommand.getUserName();
        String password=loginCommand.getPassword();
        if(account=="")
        {
            result.setResult("fail");
            result.setMsg("账号和密码不能为空");
            result.setStatus(500);
        }
        else
        {
            if(loginCommand.getRole().equals("学生"))
            {
                Student student=sLoginCheck(account,password);
                if(student==null)
                {
                    result.setStatus(201);
                    result.setResult("fail");
                    result.setMsg("账号或密码错误");
                }
                else
                    result.setData(student);

            }
            if(loginCommand.getRole().equals("教师"))
            {
                Teacher teacher=tLoginCheck(account,password);
                if(teacher==null)
                {
                    result.setStatus(201);
                    result.setResult("fail");
                    result.setMsg("账号或密码错误");
                }
                else
                    result.setData(teacher);

            }
            if(loginCommand.getRole().equals("管理员"))
            {
                Administrator administrator=aLoginCheck(account,password);
                if(administrator==null)
                {
                    result.setStatus(201);
                    result.setResult("fail");
                    result.setMsg("账号或密码错误");
                }
                else
                    result.setData(administrator);
            }
        }
        return result;
    }

    //检查管理员登录
    private Administrator aLoginCheck(String account,String password)
    {
        Administrator a = adminDAO.findByAccount(account);
        if(a!=null&&a.getPwd().equals(password))
            return a;
        else
            return null;
    }

    //检查教师登陆
    private  Teacher tLoginCheck(String account, String password){
        Teacher t = teacherDAO.findByTno(account);
        if(t!=null && t.getPassword().equals(password))
            return t;
        else
            return null;
    }
    //检查学生登陆
    private Student sLoginCheck(String account, String password){
        Student s = studentDAO.findBySno(account);
        if(s!=null && s.getPassword().equals(password))
            return s;
        else
            return null;
    }
}
