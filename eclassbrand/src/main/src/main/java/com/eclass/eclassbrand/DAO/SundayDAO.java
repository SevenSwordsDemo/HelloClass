package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Sunday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SundayDAO extends JpaRepository<Sunday,Long> {
    //根据教室找安排
    public List<Sunday> findByClassroom(String classroom);

    List<Sunday> findByCno(String cno);

    List<Sunday> findByTno(String tno);
}
