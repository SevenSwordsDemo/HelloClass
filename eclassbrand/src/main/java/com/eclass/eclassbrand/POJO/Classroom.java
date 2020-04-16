package com.eclass.eclassbrand.POJO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="classroom")
public class Classroom implements Serializable {
    private static final long serialVersionUID = -4633708003841860149L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String floor;
    @Column(name = "class_num")
    private String classNum;
    @Column(name="device_id")
    private String deviceId;
    @Column(name="device_state")
    private String deviceState;

    public Classroom() {
    }

    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getClassNum() {
        return classNum;
    }
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceState() {
        return deviceState;
    }
    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }
}
