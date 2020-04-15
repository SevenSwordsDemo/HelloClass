package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Saturday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaturdayDAO extends JpaRepository<Saturday,Long> {
    //根据教室找安排
    public List<Saturday> findByClassroom(String classroom);

    List<Saturday> findByCno(String cno);

    List<Saturday> findByTno(String tno);
}
