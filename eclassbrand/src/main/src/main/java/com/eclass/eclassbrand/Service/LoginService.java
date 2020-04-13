package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.StudentDAO;
import com.eclass.eclassbrand.DAO.TeacherDAO;
import com.eclass.eclassbrand.POJO.Student;
import com.eclass.eclassbrand.POJO.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    TeacherDAO teacherDAO;
    @Resource
    StudentDAO studentDAO;

    //检查教师登陆
    public Teacher tLoginCheck(String account, String password){
        Teacher t = teacherDAO.findByTno(account);
        if(t!=null && t.getPassword().equals(password))
            return t;
        else
            return null;
    }
    //检查学生登陆
    public Student sLoginCheck(String account, String password){
        Student s = studentDAO.findBySno(account);
        if(s!=null && s.getPassword().equals(password))
            return s;
        else
            return null;
    }
}
