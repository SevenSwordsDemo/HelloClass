package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Sunday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SundayDAO extends JpaRepository<Sunday,Long> {
    //根据楼名找安排
    @Query(value = "select * from sunday where classroom LIKE CONCAT(:classroom,'%')", nativeQuery = true)
    List<Sunday> findByClassroomLike(@Param("classroom") String classroom );

    List<Sunday> findAllByOrderByStart();

    List<Sunday> findByCno(String cno);

    List<Sunday> findByTno(String tno);
}
