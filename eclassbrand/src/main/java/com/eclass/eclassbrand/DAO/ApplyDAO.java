package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ApplyDAO extends JpaRepository<Apply, BigInteger> {

    List<Apply> findByScheduleAndState(String schedule, String state);
}
