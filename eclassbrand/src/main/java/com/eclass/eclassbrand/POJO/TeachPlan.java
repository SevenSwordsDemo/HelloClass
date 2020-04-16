package com.eclass.eclassbrand.POJO;

public class TeachPlan {

    String cname;
    String classroom;
    int start;
    int end;
    int size;

    public TeachPlan(String cname, String classroom, int start, int end, int size) {
        this.cname = cname;
        this.classroom = classroom;
        this.start = start;
        this.end = end;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
