package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course,Long> {

    Course findByCno(String cno);
}
