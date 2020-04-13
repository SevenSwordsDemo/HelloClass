package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name="apply")
@JsonInclude(JsonInclude.Include.NON_NULL)//如果字段为空则不进行序列化
public class Apply implements Serializable {
  private static final long serialVersionUID = -6615059567194245149L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;
  @Column(name="sno",nullable = false)
  private String sno;
  @Column(name="classroom",nullable = false)
  private String classroom;
  @Column(name="schedule",nullable = false)
  private String schedule;
  @Column(name="state")
  private String state;
  @Column(name="reason")
  private String reason;

  @OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY,targetEntity = Student.class)
  @JoinColumn(name = "sno",insertable=false, updatable=false,foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Student student;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }


  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno;
  }


  public String getClassroom() {
    return classroom;
  }

  public void setClassroom(String classroom) {
    this.classroom = classroom;
  }


  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
