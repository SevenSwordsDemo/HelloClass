package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface StudentDAO extends JpaRepository<Student, BigInteger> {

    Student findBySno(String sno);
}
