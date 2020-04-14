package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Signin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SigninDAO extends JpaRepository<Signin,Long> {

    List<Signin> findByCnoAndWeekAndDayOfWeek(String cno, String week, String dayofweek);
}
