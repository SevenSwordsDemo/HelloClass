package com.eclass.eclassbrand.POJO;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="apply")
@JsonInclude(JsonInclude.Include.NON_NULL)//如果字段为空则不进行序列化
public class Apply implements Serializable {
  private static final long serialVersionUID = -6615059567194245149L;

  public interface SimpleView extends CommonResult.CommonResultView {};
  public interface DetailView extends ClassroomPlan.CommonView {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="sid",nullable = false)
  private String sid;
  @Column(name="classroom",nullable = false)
  private String classroom;
  private int start;
  private int end;
  @Column(name="state")
  private String state;
  @Column(name="reason")
  private String reason;
  @Column(name = "apply_time",nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Timestamp applyTime;
  @Column(name = "day_of_week",nullable = false)
  private String dayOfWeek;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd")
  private Date date;
  private Integer week;

  public Apply() {
  }

  public Apply(String sid, String classroom, int start, int end, String state, String reason, Timestamp applyTime, String dayOfWeek, Date date, Integer week) {
    this.sid = sid;
    this.classroom = classroom;
    this.start = start;
    this.end = end;
    this.state = state;
    this.reason = reason;
    this.applyTime = applyTime;
    this.dayOfWeek = dayOfWeek;
    this.date = date;
    this.week = week;
  }

  @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
  @JoinColumn(name = "sid",insertable=false, updatable=false)
  @JsonIgnoreProperties(value = {"applyList"})
  private Student student;

  @JsonView(DetailView.class)
  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @JsonView(SimpleView.class)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @JsonView(SimpleView.class)
  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  @JsonView(SimpleView.class)
  public String getClassroom() {
    return classroom;
  }

  public void setClassroom(String classroom) {
    this.classroom = classroom;
  }
  @JsonView(SimpleView.class)
  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }
  @JsonView(SimpleView.class)
  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }
  @JsonView(SimpleView.class)
  public Timestamp getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(Timestamp applyTime) {
    this.applyTime = applyTime;
  }
  @JsonView(SimpleView.class)
  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }
  @JsonView(SimpleView.class)
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @JsonView(SimpleView.class)
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @JsonView(SimpleView.class)
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @JsonView(SimpleView.class)
  public Integer getWeek() {
    return week;
  }
  public void setWeek(Integer week) {
    this.week = week;
  }


}
