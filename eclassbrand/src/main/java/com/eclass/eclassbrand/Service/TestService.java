package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.TeacherDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {

    @Resource
    TeacherDAO teacherDAO;
    public CommonResult sample()
    {
        CommonResult result=new CommonResult();
        try {
            Teacher teacher=new Teacher();
            teacher.setName("王重阳");
            teacher.setGender("男");
            teacher.setAcademy("计算机学院");
            teacher.setTno("t123456");
            teacher.setPassword("123456");

        }
        catch (Exception e)
        {
            result.setStatus(500);
            result.setMsg("服务器错误");
        }
        return result;

    }
}
