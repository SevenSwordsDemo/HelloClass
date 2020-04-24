package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="administrator")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Administrator implements Serializable {
    private static final long serialVersionUID = -6615059567194245149L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String account;
    @Column(name = "password")
    @JsonIgnore
    private String pwd;

    public Administrator() {
    }

    public Administrator(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
