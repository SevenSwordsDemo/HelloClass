package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Thursday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThursdayDAO extends JpaRepository<Thursday,Long> {
    //根据楼名找安排
    List<Thursday> findByClassroomLike(String classroom);

    List<Thursday> findAllByOrOrderByStart();

    List<Thursday> findByCno(String cno);

    List<Thursday> findByTno(String tno);
}
