package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AdminDAO extends JpaRepository<Administrator, BigInteger> {

    Administrator findByAccount(String account);

    @Modifying
    void deleteByAccount(String account);
}
