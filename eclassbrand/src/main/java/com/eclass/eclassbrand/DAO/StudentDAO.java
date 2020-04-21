package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    Student findBySno(String sno);

    @Query(value = "select * from student where name=?1",nativeQuery = true)
    Student findByName(String name);

    //分页获取学生
    Page<Student> findAll(Pageable pageable);

    //获取学院列表
    @Query(value = "select distinct academy from student",nativeQuery = true)
    List<String> getAcademy();

    //获取学院班级
    @Query(value = "select distinct class from student where academy=?1",nativeQuery = true)
    List<String> getClassesByAcademy(String academy);

    //分页获取某学院学生信息
    Page<Student> findAllByAcademy(String academy,Pageable pageable);

    //根据学院班级获取学生信息
    List<Student> findAllByAcademyAndClasses(String academy,String classes);
}
