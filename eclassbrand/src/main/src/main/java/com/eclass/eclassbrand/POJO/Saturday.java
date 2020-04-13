package com.eclass.eclassbrand.POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="saturday")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Saturday implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String tno;
  private String cno;
  private String schedule;
  private String classroom;

  @OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  @JoinColumn(name = "cno",insertable=false, updatable=false,foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Course course;

  @OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  @JoinColumn(name = "tno",insertable=false, updatable=false,foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Teacher teacher;

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTno() {
    return tno;
  }

  public void setTno(String tno) {
    this.tno = tno;
  }


  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
  }


  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }


  public String getClassroom() {
    return classroom;
  }

  public void setClassroom(String classroom) {
    this.classroom = classroom;
  }

}
