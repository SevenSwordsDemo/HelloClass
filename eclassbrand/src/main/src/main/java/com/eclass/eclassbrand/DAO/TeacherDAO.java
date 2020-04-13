package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TeacherDAO extends JpaRepository<Teacher, BigInteger> {

    Teacher findByTno(String tno);
}
