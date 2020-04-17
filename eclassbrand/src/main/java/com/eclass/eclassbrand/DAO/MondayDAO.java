package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Monday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MondayDAO extends JpaRepository<Monday, Long> {
    //根据楼名找安排
    List<Monday> findByClassroomLike(String build);

    List<Monday> findAllByOrderByStart();

    //查询这门课安排
    List<Monday> findByCno(String cno);

    @Query(value = "select cno from monday",nativeQuery = true)
    List<String> getCno();

    List<Monday> findByTno(String tno);
}
