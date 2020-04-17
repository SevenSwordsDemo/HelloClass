package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

    Teacher findByTno(String tno);
}
