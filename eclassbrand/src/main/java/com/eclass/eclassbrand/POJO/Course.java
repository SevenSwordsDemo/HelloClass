package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="course")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Course implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String cno;
  private String cname;

  @OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY,targetEntity = SelectedCourse.class)
  @JoinColumn(name = "cno",insertable=false, updatable=false,foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private List<SelectedCourse> selectedCourses;

  public List<SelectedCourse> getSelectedCourses() {
    return selectedCourses;
  }

  public void setSelectedCourses(List<SelectedCourse> selectedCourses) {
    this.selectedCourses = selectedCourses;
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


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

}
