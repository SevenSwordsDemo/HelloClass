package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Wednesday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WednesdayDAO extends JpaRepository<Wednesday,Long> {
    //根据楼名找安排
    @Query(value = "select * from wednesday where classroom LIKE CONCAT(:classroom,'%')", nativeQuery = true)
    List<Wednesday> findByClassroomLike(@Param("classroom") String classroom );

    List<Wednesday> findAllByOrderByStart();

    List<Wednesday> findByCno(String cno);

    List<Wednesday> findByTno(String tno);
}
