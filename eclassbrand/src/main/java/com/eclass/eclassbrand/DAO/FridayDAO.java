package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Friday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridayDAO extends JpaRepository<Friday,Long> {
    //根据教楼名找安排
    public List<Friday> findByClassroomLike(String classroom);

    List<Friday> findAllByOrderByStart();

    List<Friday> findByCno(String cno);

    List<Friday> findByTno(String tno);
}
