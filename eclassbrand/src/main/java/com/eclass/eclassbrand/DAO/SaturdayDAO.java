package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Friday;
import com.eclass.eclassbrand.POJO.Saturday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaturdayDAO extends JpaRepository<Saturday,Long> {
    //根据楼名找安排
    @Query(value = "select * from saturday where classroom LIKE CONCAT(:classroom,'%')", nativeQuery = true)
    List<Saturday> findByClassroomLike(@Param("classroom") String classroom );

    List<Saturday> findAllByOrderByStart();

    List<Saturday> findByCno(String cno);

    List<Saturday> findByTno(String tno);
}
