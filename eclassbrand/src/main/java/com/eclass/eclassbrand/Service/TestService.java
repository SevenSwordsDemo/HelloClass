package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.DAO.ClassroomDAO;
import com.eclass.eclassbrand.DAO.TeacherDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.POJO.Classroom;
import com.eclass.eclassbrand.POJO.Teacher;
import com.eclass.eclassbrand.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TestService {

    @Resource
    TeacherDAO teacherDAO;
    @Resource
    ApplyDAO applyDAO;

    @Resource
    ClassroomDAO classroomDAO;

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

    public CommonResult addAplly() {
        CommonResult result = new CommonResult();
        SimpleDateFormat formattter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Timestamp now = Timestamp.valueOf(formattter3.format(new Date()));
        try {
        Apply apply=new Apply();
        apply.setApplyTime(Timestamp.valueOf(formattter3.format(now)));
        apply.setClassroom("广B203");
        apply.setDate(new java.sql.Date(format.parse("2020-04-25 20:48:02.0").getTime()));
        apply.setStart(1);
        apply.setEnd(3);
        apply.setDayOfWeek(Util.getWeekOfDate(format.parse("2020-04-25 20:48:02.0")));
        apply.setWeek(3);
        apply.setState("待审核");
        apply.setReason("志协社团会议");
        apply.setSid(1);
        result.setData(applyDAO.save(apply));
        result.setMsg("信息添加成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("服务器错误");
            result.setResult("fail");
        }
        return result;
    }

    public CommonResult addClassroom()
    {
        CommonResult result=new CommonResult();
        Classroom classroom=new Classroom("广B","203");
        result.setData(classroomDAO.save(classroom));
        return result;
    }

}
