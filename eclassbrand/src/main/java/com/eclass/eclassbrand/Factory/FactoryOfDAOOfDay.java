package com.eclass.eclassbrand.Factory;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.POJO.Thursday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FactoryOfDAOOfDay {
    @Resource
    FridayDAO fridayDAO;
    @Resource
    ThursdayDAO thursdayDAO;
    @Resource
    WednesdayDAO wednesdayDAO;
    @Resource
    TuesdayDAO tuesdayDAO;
    @Resource
    MondayDAO mondayDAO;
    @Resource
    SaturdayDAO saturdayDAO;
    @Resource
    SundayDAO sundayDAO;



    public BasicDAOOfDay createDaoOfDay(String day)
    {
        BasicDAOOfDay daoOfDay=null;
        switch (day)
        {
            case "Monday":daoOfDay=mondayDAO;
            break;
            case "Tuesday": daoOfDay=tuesdayDAO;
            break;
            case "Wednesday": daoOfDay=wednesdayDAO;
            break;
            case "Thursday": daoOfDay=thursdayDAO;
            break;
            case  "Friday": daoOfDay=fridayDAO;
            break;
            case "Saturday": daoOfDay=saturdayDAO;
            break;
            case "Sunday": daoOfDay=sundayDAO;
        }
        return daoOfDay;

    }




}
