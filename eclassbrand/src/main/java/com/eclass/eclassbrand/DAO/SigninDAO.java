package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Signin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SigninDAO extends JpaRepository<Signin,Long> {

    @Query(value = "select * from signin where cno=?1 and week=?2 and day_of_week=?3",nativeQuery = true)
    List<Signin> findByCnoAndWeekAndDayOfWeek(String cno, int week, String dayofweek);
}
