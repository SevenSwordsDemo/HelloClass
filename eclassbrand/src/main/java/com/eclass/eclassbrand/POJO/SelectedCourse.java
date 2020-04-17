package com.eclass.eclassbrand.POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="selected_course")
@JsonInclude(JsonInclude.Include.NON_NULL)//如果字段为空则不进行序列化
public class SelectedCourse implements Serializable {

  private static final long serialVersionUID = -6615059567194245149L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String sno;
  private String cno;
  private String tno;

  @ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY,targetEntity = Course.class)
  @JoinColumn(name = "cno",insertable=false, updatable=false,referencedColumnName = "cno")
  @JsonIgnoreProperties(value = {"selectedCourses"})
  private Course course;


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


  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno;
  }


  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
  }


  public String getTno() {
    return tno;
  }

  public void setTno(String tno) {
    this.tno = tno;
  }

}
