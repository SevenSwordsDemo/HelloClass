package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Signin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SigninDAO extends JpaRepository<Signin,Long> {

    List<Signin> findByCnoAndWeekAndDayOfWeek(String cno, String week, String dayofweek);
}
