package com.eclass.eclassbrand.POJO;

public class ClassroomPlan {
    String classroom;
    int start;
    int end;
    String state;
    String user;
    String activity;
    public ClassroomPlan(String classroom, int start, int end, String state, String user) {
        this.classroom = classroom;
        this.start = start;
        this.end = end;
        this.state = state;
        this.user = user;
    }

    public ClassroomPlan(String classroom, int start, int end, String state, String user, String activity) {
        this.classroom = classroom;
        this.start = start;
        this.end = end;
        this.state = state;
        this.user = user;
        this.activity = activity;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
