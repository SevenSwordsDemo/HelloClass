package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    ApplyDAO applyDAO;
    @Resource
    MondayDAO mondayDAO;
    @Resource
    TuesdayDAO tuesdayDAO;
    @Resource
    WednesdayDAO wednesdayDAO;
    @Resource
    ThursdayDAO thursdayDAO;
    @Resource
    FridayDAO fridayDAO;
    @Resource
    SaturdayDAO saturdayDAO;
    @Resource
    SundayDAO sundayDAO;

    //保存申请记录
    public void saveApplyRecord(Apply apply){
        try {
            applyDAO.save(apply);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //查看周一课程安排
    public List<Monday> findMonday(){
        return mondayDAO.findAll();
    }
    //查看周二课程安排
    public List<Tuesday> findTuesday(){
        return tuesdayDAO.findAll();
    }
    //查看周三课程安排
    public List<Wednesday> findWednesday(){
        return wednesdayDAO.findAll();
    }
    //查看周四课程安排
    public List<Thursday> findThursday(){
        return thursdayDAO.findAll();
    }
    //查看周五课程安排
    public List<Friday> findFriday(){
        return fridayDAO.findAll();
    }
    //查看周六课程安排
    public List<Saturday> findSaturday(){
        return saturdayDAO.findAll();
    }
    //查看周日课程安排
    public List<Sunday> findSunday(){
        return sundayDAO.findAll();
    }

    //按教室搜索周一安排
    public List<Monday> findByClassroom1(String classroom){
        return mondayDAO.findByClassroom(classroom);
    }
    //按教室搜索周二安排
    public List<Tuesday> findByClassroom2(String classroom){
        return tuesdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周三安排
    public List<Wednesday> findByClassroom3(String classroom){
        return wednesdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周四安排
    public List<Thursday> findByClassroom4(String classroom){
        return thursdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周五安排
    public List<Friday> findByClassroom5(String classroom){
        return fridayDAO.findByClassroom(classroom);
    }
    //按教室搜索周六安排
    public List<Saturday> findByClassroom6(String classroom){
        return saturdayDAO.findByClassroom(classroom);
    }
    //按教室搜索周日安排
    public List<Sunday> findByClassroom7(String classroom){
        return sundayDAO.findByClassroom(classroom);
    }
}
