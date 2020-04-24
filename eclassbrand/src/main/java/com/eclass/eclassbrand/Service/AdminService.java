package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.AdminDAO;
import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.DAO.StudentDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.POJO.Student;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;


@Service
public class AdminService {
    @Resource
    private AdminDAO adminDAO;
    @Resource
    private ApplyDAO applyDAO;
    @Resource
    private StudentDAO studentDAO;



    //获取管理员列表
    public CommonResult getAdminList()
    {
        CommonResult result=new CommonResult();
        List<Administrator> administrators=adminDAO.findAll();
        if(administrators.size()>0)
        {
            result.setMsg("获取管理员列表成功");
            result.setData(administrators);
            result.setLengthOfData(administrators.size());
        }
        else
        {
            result.setMsg("暂无数据");
            result.setResult("fail");
            result.setStatus(201);
        }
        return result;
    }

    //添加管理员
    public CommonResult addAdmin(Administrator administrator)
    {
        CommonResult result=new CommonResult();
        try {
            adminDAO.save(administrator);
            result.setMsg("添加成功");
            result.setData(administrator.getId());
        }
        catch (Exception e)
        {
            result.setStatus(500);
            result.setMsg("服务器错误");
            result.setResult("fail");
            e.printStackTrace();
        }
        return result;
    }

    //删除管理员
    @Transactional
    public CommonResult delAdmin(String account)
    {
        CommonResult result=new CommonResult();
        try
        {
            adminDAO.deleteByAccount(account);
            result.setMsg("删除成功");
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

    //处理申请
    @Transactional
    public CommonResult handleApply(String operate,int id)
    {
        CommonResult result=new CommonResult();
        Apply apply=applyDAO.getOne(Long.valueOf(id));
        if(operate.equals("agree"))
        {
            apply.setState("通过");
            applyDAO.save(apply);
            result.setMsg("申请已同意");
            result.setData(apply.getState());
        }
        else if(operate.equals("deny"))
        {
            applyDAO.delete(apply);
            result.setMsg("已拒绝该申请");
        }
        return result;
    }

    //获取所有学生信息
    public CommonResult getAllStudent(int page,int size)
    {
        CommonResult result=new CommonResult();
        PageRequest pageRequest=PageRequest.of(page,size);
        List<Student> students=null;
        try {
            Page<Student> studentPage = studentDAO.findAll(pageRequest);
            students = studentPage.getContent();
            if (students.size() > 0) {
                result.setMsg("获取学生信息成功");
                result.setLengthOfData(studentPage.getTotalElements());
                result.setData(students);
            } else {
                result.setResult("fail");
                result.setMsg("暂无数据");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setResult("fail");
            result.setMsg("服务器错误");
        }
        return result;

    }

    //获取所有学院列表
    public CommonResult getAcademy()
    {
        CommonResult result=new CommonResult();
        List<String> academies=studentDAO.getAcademy();
        if(academies.size()>0)
        {
            result.setMsg("获取学院列表成功");
            result.setData(academies);
            result.setLengthOfData(academies.size());
        }
        else
        {
            result.setMsg("暂无数据");
        }
        return result;
    }

    //获取学院班级列表
    public CommonResult getClassesAcademy(String academy)
    {
        CommonResult result=new CommonResult();
        List<String> classes=studentDAO.getClassesByAcademy(academy);
        if(classes.size()>0)
        {
            result.setMsg("获取班级列表成功");
            result.setData(classes);
            result.setLengthOfData(classes.size());
        }
        else
            result.setMsg("暂无数据");
        return result;
    }


    //分页获取某学院学生信息
    public CommonResult getStudentsByAcademy(int page,int size,String academy)
    {
        CommonResult result=new CommonResult();
        PageRequest pageRequest=PageRequest.of(page,size);
        List<Student> students=null;
        try {
            Page<Student> studentPage = studentDAO.findAllByAcademy(academy, pageRequest);
            students = studentPage.getContent();
            if (students.size() > 0) {
                result.setMsg("获取学生信息成功");
                result.setData(students);
                result.setLengthOfData(studentPage.getTotalElements());
            } else
                result.setMsg("暂无数据");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setResult("fail");
            result.setStatus(500);
            result.setMsg("服务器错误");
        }
        return result;
    }

    //根据学院班级获取学生信息
    public CommonResult getStudentsOfClass(String academy,String classes)
    {
        CommonResult result=new CommonResult();
        List<Student> students=studentDAO.findAllByAcademyAndClasses(academy,classes);
        if(students.size()>0)
        {
            result.setMsg("获取学生信息成功");
            result.setData(students);
            result.setLengthOfData(students.size());
        }
        else
            result.setMsg("暂无数据");
        return result;
    }

}
