package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name="teacher")
@JsonInclude(JsonInclude.Include.NON_NULL)//如果字段为空则不进行序列化
public class Teacher implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;
  @Column(name="tno",nullable = false)
  private String tno;
  @Column(name="name",nullable = false)
  private String name;
  @Column(name="password",nullable = false)
  private String password;
  @Column(name="gender",nullable = false)
  private String gender;
  @Column(name="academy",nullable = false)
  private String academy;


  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }


  public String getTno() {
    return tno;
  }

  public void setTno(String tno) {
    this.tno = tno;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getAcademy() {
    return academy;
  }

  public void setAcademy(String academy) {
    this.academy = academy;
  }

}
