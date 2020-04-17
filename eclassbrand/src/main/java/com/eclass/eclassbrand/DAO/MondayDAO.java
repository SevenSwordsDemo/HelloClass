package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Monday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MondayDAO extends JpaRepository<Monday, Long> {
    @Query(value = "select * from monday where classroom LIKE CONCAT(:classroom,'%')", nativeQuery = true)
    List<Monday> findByClassroomLike(@Param("classroom") String classroom );

    List<Monday> findAllByOrderByStart();

    //查询这门课安排
    List<Monday> findByCno(String cno);

    List<Monday> findByTno(String tno);
}
