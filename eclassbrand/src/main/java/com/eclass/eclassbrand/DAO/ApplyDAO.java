package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ApplyDAO extends JpaRepository<Apply, Long> {


    @Query(value = "select * from apply where state=?1",nativeQuery = true)
    List<Apply> findByState(String state);

    @Query(value = "select * from apply where week=:week and day_of_week=:day and state=:state and classroom LIKE CONCAT('%',:build,'%')",nativeQuery = true)
    List<Apply> findByWeekAndDayOfWeekAndStateAndClassroomContaining(@Param("week")int week, @Param("day")String day, @Param("state")String state,@Param("build")String build);

    @Query(value = "select * from apply where week=?1 and day_of_week=?2 and state=?3",nativeQuery = true)
    List<Apply> findByWeekAndDayOfWeekAndState(int week,String theday,String state);


}
