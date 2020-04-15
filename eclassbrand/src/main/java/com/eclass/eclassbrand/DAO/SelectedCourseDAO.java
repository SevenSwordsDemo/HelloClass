package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.SelectedCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectedCourseDAO extends JpaRepository<SelectedCourse,Long> {

    List<SelectedCourse> findByTno(String tno);
}
