package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.DayOfWeek;
import com.eclass.eclassbrand.POJO.Friday;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicDAOOfDay {
    //查询该栋楼所有教室
    List<String> getClassroom(String build,int week);

    //根据教楼名找安排
    List<DayOfWeek> findByClassroomLike(String classroom, int week );

    //根据时间获取日程
    List<DayOfWeek> findAllByOrderByStart(int week);

    //获取该表所有教室
    List<String> getAllClassroom(int week);

    //获取某教室当天日程
    List<DayOfWeek> getScheduleOfClass(int week,String classroom);


}
