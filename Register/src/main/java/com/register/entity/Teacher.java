package com.register.entity;




public class Teacher {

    private String teachNo;
    private String teachPassword;
    private String teachName;
    private String teachPhone;
    private String teachEmail;
    private String departNo;

    public Teacher() {
    }

    public Teacher(String teachNo, String teachPassword, String teachName, String teachPhone, String teachEmail, String departNo) {
        this.teachNo = teachNo;
        this.teachPassword = teachPassword;
        this.teachName = teachName;
        this.teachPhone = teachPhone;
        this.teachEmail = teachEmail;
        this.departNo = departNo;
    }

    public String getTeachNo() {
        return teachNo;
    }

    public void setTeachNo(String teachNo) {
        this.teachNo = teachNo;
    }

    public String getTeachPassword() {
        return teachPassword;
    }

    public void setTeachPassword(String teachPassword) {
        this.teachPassword = teachPassword;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getDepartNo() {
        return departNo;
    }

    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

    public String getTeachPhone() {
        return teachPhone;
    }

    public void setTeachPhone(String teachPhone) {
        this.teachPhone = teachPhone;
    }

    public String getTeachEmail() {
        return teachEmail;
    }

    public void setTeachEmail(String teachEmail) {
        this.teachEmail = teachEmail;
    }
}
