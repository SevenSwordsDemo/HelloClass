package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.POJO.Monday;
import com.eclass.eclassbrand.POJO.Thursday;
import com.eclass.eclassbrand.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TestService {

    @Resource
    TeacherDAO teacherDAO;
    @Resource
    ApplyDAO applyDAO;
    @Resource
    ThursdayDAO thursdayDAO;
    @Resource
    StudentDAO studentDAO;
    @Resource
    ClassroomDAO classroomDAO;

    @Resource
    MondayDAO mondayDAO;

    public CommonResult test()
    {
        CommonResult result=new CommonResult();
        try {
           result.setData(mondayDAO.getCno());
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
//        Classroom classroom=new Classroom("广B","102");
//        result.setData(classroomDAO.save(classroom));
        Thursday thursday=new Thursday("t123456","c06",8,9,"博文B101","1-8");
        thursdayDAO.save(thursday);
        return result;
    }

    public Monday getMonday()
    {
        return mondayDAO.getOne(Long.valueOf(1));
    }



}
