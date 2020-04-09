package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleDAO extends JpaRepository<Administrator,Integer> {

}
