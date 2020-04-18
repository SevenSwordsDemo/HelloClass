package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.DayOfWeek;
import com.eclass.eclassbrand.POJO.Monday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface MondayDAO extends JpaRepository<Monday, Long>, BasicDAOOfDay {
    @Query(value = "select * from monday where classroom LIKE ?1 and find_in_set(?2,week)", nativeQuery = true)
    List<DayOfWeek> findByClassroomLike(String classroom,int week );

    @Query(value ="select * from monday where find_in_set(?1,week) order by start",nativeQuery = true)
    List<DayOfWeek> findAllByOrderByStart(int week);

    //查询这门课安排
    List<Monday> findByCno(String cno);

    @Query(value = "select cno from monday",nativeQuery = true)
    List<String> getCno();

    List<Monday> findByTno(String tno);

    //查询该栋楼所有教室
    @Query(value = "select distinct classroom from monday where classroom like ?1 and find_in_set(?2,week)",nativeQuery = true)
    List<String> getClassroom(String build,int week);

    @Query(value = "select * from monday where classroom=?1 and find_in_set(?2,week)",nativeQuery = true)
    List<DayOfWeek> findAllByClassroom(String classroom,int week);

    //获取该表所有教室
    @Query(value = "select distinct classroom from monday where find_in_set(?1,week)",nativeQuery = true)
    List<String> getAllClassroom(int week);

    //获取某教室当天日程
    @Query(value = "select * from monday where find_in_set(?1,week) and classroom=?2",nativeQuery = true)
    List<DayOfWeek> getScheduleOfClass(int week,String classroom);



}
