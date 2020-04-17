package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Tuesday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuesdayDAO extends JpaRepository<Tuesday, Long> {
    //根据楼名找安排
    @Query(value = "select * from tuesday where classroom LIKE CONCAT(:classroom,'%')", nativeQuery = true)
    List<Tuesday> findByClassroomLike(@Param("classroom") String classroom );

    List<Tuesday> findAllByOrderByStart();

    //查询这门课安排
    List<Tuesday> findByCno(String cno);

    List<Tuesday> findByTno(String tno);
}
