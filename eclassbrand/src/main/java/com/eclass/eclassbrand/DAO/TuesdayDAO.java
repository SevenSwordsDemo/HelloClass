package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Tuesday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuesdayDAO extends JpaRepository<Tuesday, Long> {
    //根据教室找安排
    List<Tuesday> findByClassroom(String classroom);

    //查询这门课安排
    List<Tuesday> findByCno(String cno);

    List<Tuesday> findByTno(String tno);
}
