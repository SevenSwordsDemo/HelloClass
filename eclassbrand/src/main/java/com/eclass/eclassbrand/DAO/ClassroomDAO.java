package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomDAO  extends JpaRepository<Classroom, Long> {

}
