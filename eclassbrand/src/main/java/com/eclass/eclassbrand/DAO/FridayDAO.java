package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Friday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FridayDAO extends JpaRepository<Friday,Long> {
    //根据教室找安排
    public List<Friday> findByClassroom(String classroom);

    List<Friday> findByCno(String cno);

    List<Friday> findByTno(String tno);
}
