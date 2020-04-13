package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Wednesday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WednesdayDAO extends JpaRepository<Wednesday,Long> {
    //根据教室找安排
    List<Wednesday> findByClassroom(String classroom);

    List<Wednesday> findByCno(String cno);

    List<Wednesday> findByTno(String tno);
}
