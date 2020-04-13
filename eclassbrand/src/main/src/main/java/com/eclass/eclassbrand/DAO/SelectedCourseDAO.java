package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.SelectedCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectedCourseDAO extends JpaRepository<SelectedCourse,Long> {

    List<SelectedCourse> findByTno(String tno);
}
