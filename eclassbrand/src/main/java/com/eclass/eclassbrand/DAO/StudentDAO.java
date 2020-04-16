package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface StudentDAO extends JpaRepository<Student, BigInteger> {

    Student findBySno(String sno);

    @Query(value = "select * from student where name=?1",nativeQuery = true)
    Student findByName(String name);
}
