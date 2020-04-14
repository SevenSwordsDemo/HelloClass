package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="signin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Signin implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String cno;
  private String tname;
  private long week;
  private String dayOfWeek;
  private String sno;

  @OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  @JoinColumn(name = "cno",insertable=false, updatable=false,foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Course course;

  @OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  @JoinColumn(name = "sno",insertable=false, updatable=false,foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Student student;

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public long getWeek() {
    return week;
  }

  public void setWeek(long week) {
    this.week = week;
  }


  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }


  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno;
  }

}
