package com.eclass.eclassbrand.POJO;

import com.eclass.eclassbrand.Modal.CommonResult;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassroomPlan implements Serializable {
    private static final long serialVersionUID = 3323829657228223687L;

    public interface CommonView extends CommonResult.CommonResultView {};
    public interface AdminView extends CommonView{}
    String classroom;
    String deviceState;
    List<Schedule> schedules=new ArrayList<>();

    public ClassroomPlan(String classroom, String deviceState, List<Schedule> schedules) {
        this.classroom = classroom;
        this.deviceState = deviceState;
        this.schedules = schedules;
    }

    public ClassroomPlan(String classroom, String deviceState) {
        this.classroom = classroom;
        this.deviceState = deviceState;
    }

    public ClassroomPlan(String classroom) {
        this.classroom = classroom;
    }

    @JsonView(CommonView.class)
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


    @JsonView(AdminView.class)
    public String getDeviceState() {
        return deviceState;
    }
    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    @JsonView(CommonView.class)
    public List<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
