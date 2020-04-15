package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

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
  private int start;
  private int end;
  @Column(name="state")
  private String state;
  @Column(name="reason")
  private String reason;
  @Column(name = "apply_time",nullable = false)
  private Timestamp applyTime;
  @Column(name = "day_of_week",nullable = false)
  private String dayOfWeek;
  private Timestamp date;

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

  public Timestamp getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(Timestamp applyTime) {
    this.applyTime = applyTime;
  }

  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
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
