package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Wednesday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WednesdayDAO extends JpaRepository<Wednesday,Long> {
    //根据教室找安排
    List<Wednesday> findByClassroom(String classroom);

    List<Wednesday> findByCno(String cno);

    List<Wednesday> findByTno(String tno);
}
