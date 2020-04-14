package com.eclass.eclassbrand.POJO;

public class TeachPlan {

    String cname;
    String classroom;
    String schedule;
    int size;

    public TeachPlan(String cname, String classroom, String schedule, int size) {
        this.cname = cname;
        this.classroom = classroom;
        this.schedule = schedule;
        this.size = size;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
