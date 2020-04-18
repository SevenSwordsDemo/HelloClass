package com.eclass.eclassbrand.POJO;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public class Schedule implements Serializable {
    private static final long serialVersionUID = -5366506367738266090L;
    int start;
    int end;
    String state;
    String user;
    String activity;

    public Schedule(int start, int end, String state, String user, String activity) {
        this.start = start;
        this.end = end;
        this.state = state;
        this.user = user;
        this.activity = activity;
    }

    @JsonView(ClassroomPlan.CommonView.class)
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }

    @JsonView(ClassroomPlan.CommonView.class)
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }

    @JsonView(ClassroomPlan.CommonView.class)
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @JsonView(ClassroomPlan.CommonView.class)
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    @JsonView(ClassroomPlan.CommonView.class)
    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }
}
