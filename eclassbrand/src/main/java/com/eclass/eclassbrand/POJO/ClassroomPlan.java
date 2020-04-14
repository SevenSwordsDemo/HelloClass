package com.eclass.eclassbrand.POJO;

public class ClassroomPlan {
    String classroom;
    String schedule;
    String state;
    String user;

    public ClassroomPlan(String classroom, String schedule, String state, String user) {
        this.classroom = classroom;
        this.schedule = schedule;
        this.state = state;
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
