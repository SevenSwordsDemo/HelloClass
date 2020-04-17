package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.SelectedCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectedCourseDAO extends JpaRepository<SelectedCourse,Long> {

    @Query(value = "select * from selected_course where tno=?1",nativeQuery = true)
    List<SelectedCourse> findByTno(String tno);

    @Query(value = "select sno from selected_course where cno=?1",nativeQuery = true)
    List<String> findByCno(String cno);
}
