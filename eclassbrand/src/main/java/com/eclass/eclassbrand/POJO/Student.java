package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="student")
@JsonInclude(JsonInclude.Include.NON_NULL)//如果字段为空则不进行序列化
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="sno",nullable = false)
    private String sno;
    @Column(name="password",nullable = false)
    @JsonIgnore
    private String password;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="academy",nullable = false)
    private String academy;
    @Column(name="class",nullable = false)
    private String classes;
    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="faceInfo")
    @JsonIgnore
    private String faceInfo;


    @OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "sid",insertable=false, updatable=false)
    private List<Apply> applyList;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }


  public String getSno() {
    return sno;
  }
  public void setSno(String sno) {
    this.sno = sno;
  }


  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  public String getAcademy() {
    return academy;
  }
  public void setAcademy(String academy) {
    this.academy = academy;
  }


  public String getClasses() {
    return classes;
  }
  public void setClasses(String classes) {
        this.classes = classes;
    }

  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getFaceInfo() {
    return faceInfo;
  }
  public void setFaceInfo(String faceInfo) {
    this.faceInfo = faceInfo;
  }

  public List<Apply> getApplyList() {
        return applyList;
    }
    public void setApplyList(List<Apply> applyList) {
        this.applyList = applyList;
    }


}
