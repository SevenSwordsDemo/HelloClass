package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Monday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MondayDAO extends JpaRepository<Monday, BigInteger> {
    //根据教室找安排
    List<Monday> findByClassroom(String classroom);

    //查询这门课安排
    List<Monday> findByCno(String cno);

    List<Monday> findByTno(String tno);
}
