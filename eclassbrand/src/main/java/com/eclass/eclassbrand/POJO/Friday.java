package com.eclass.eclassbrand.POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="friday")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Friday implements Serializable {

  private static final long serialVersionUID = -6615059567194245149L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String tno;
  private String cno;
  private int start;
  private int end;
  private String classroom;
  private String week;

  @ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  @JoinColumn(name = "cno",insertable=false, updatable=false,referencedColumnName = "cno",foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Course course;

  @ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  @JoinColumn(name = "tno",insertable=false, updatable=false,referencedColumnName = "tno",foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
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


  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String getWeek() {
    return week;
  }

  public void setWeek(String week) {
    this.week = week;
  }

  public String getClassroom() {
    return classroom;
  }

  public void setClassroom(String classroom) {
    this.classroom = classroom;
  }

}
