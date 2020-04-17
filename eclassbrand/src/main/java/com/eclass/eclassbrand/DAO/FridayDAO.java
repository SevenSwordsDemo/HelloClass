package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Friday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridayDAO extends JpaRepository<Friday,Long> {
    //根据教楼名找安排
    @Query(value = "select * from friday where classroom LIKE CONCAT(:classroom,'%')", nativeQuery = true)
    List<Friday> findByClassroomLike(@Param("classroom") String classroom );

    List<Friday> findAllByOrderByStart();

    List<Friday> findByCno(String cno);

    List<Friday> findByTno(String tno);
}
