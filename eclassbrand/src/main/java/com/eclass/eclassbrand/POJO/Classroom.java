package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "classroom")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Classroom implements Serializable {

    private static final long serialVersionUID = 3743430175643046479L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String floor;
    private String number;

    public Classroom() {
    }

    public Classroom(String floor, String number) {
        this.floor = floor;
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
