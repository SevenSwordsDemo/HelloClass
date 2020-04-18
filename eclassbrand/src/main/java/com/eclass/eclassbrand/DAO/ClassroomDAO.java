package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassroomDAO extends JpaRepository<Classroom,Long> {

    @Query(value = "select class_num from classroom where floor=?1",nativeQuery = true)
    List<String> getClassroomByFloor(String flo);

    @Query(value = "select distinct floor from classroom where device_state=?1",nativeQuery = true)
    List<String> getFloor(String state);

    @Query(value = "select device_state from classroom where floor=?1 and class_num=?2",nativeQuery = true)
    String  getDeviceState(String floor,String classNum);
}
