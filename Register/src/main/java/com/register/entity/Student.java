package com.register.entity;




public class Student {

    private String stuNo;
    private String stuName;
    private String stuPassword;
    private String stuSex;
    private String stuBirth;
    private String stuNation;
    private String stuNative;
    private String stuPhone;
    private String stuEmail;
    private String classNo;

    public Student() {
    }

    public Student(String stuNo, String stuName, String stuPassword, String stuSex, String stuBirth, String stuNation, String stuNative, String stuPhone, String stuEmail, String classNo) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuPassword = stuPassword;
        this.stuSex = stuSex;
        this.stuBirth = stuBirth;
        this.stuNation = stuNation;
        this.stuNative = stuNative;
        this.stuPhone = stuPhone;
        this.stuEmail = stuEmail;
        this.classNo = classNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuBirth() {
        return stuBirth;
    }

    public void setStuBirth(String stuBirth) {
        this.stuBirth = stuBirth;
    }

    public String getStuNation() {
        return stuNation;
    }

    public void setStuNation(String stuNation) {
        this.stuNation = stuNation;
    }

    public String getStuNative() {
        return stuNative;
    }

    public void setStuNative(String stuNative) {
        this.stuNative = stuNative;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
}
