package com.eclass.eclassbrand.POJO;

import java.util.List;

public class SigninResult {

    private String cname;
    private String classroom;
    private int signinNumber;
    private List<String> notSignin;

    public SigninResult(String cname, String classroom, int signinNumber, List<String> notSignin) {
        this.cname = cname;
        this.classroom = classroom;
        this.signinNumber = signinNumber;
        this.notSignin = notSignin;
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

    public int getSigninNumber() {
        return signinNumber;
    }

    public void setSigninNumber(int signinNumber) {
        this.signinNumber = signinNumber;
    }

    public List<String> getNotSignin() {
        return notSignin;
    }

    public void setNotSignin(List<String> notSignin) {
        this.notSignin = notSignin;
    }

    @Override
    public String toString() {
        return "SigninResult{" +
                "cname='" + cname + '\'' +
                ", classroom='" + classroom + '\'' +
                ", signinNumber=" + signinNumber +
                ", notSignin=" + notSignin +
                '}';
    }
}
