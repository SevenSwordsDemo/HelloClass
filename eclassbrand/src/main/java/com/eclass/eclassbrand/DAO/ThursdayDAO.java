package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Thursday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThursdayDAO extends JpaRepository<Thursday,Long> {
    //根据教室找安排
    public List<Thursday> findByClassroom(String classroom);

    List<Thursday> findByCno(String cno);

    List<Thursday> findByTno(String tno);
}
