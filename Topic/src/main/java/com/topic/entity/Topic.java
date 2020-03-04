package com.topic.entity;

public class Topic {
    private String titleNo;
    private String titleName;
    private String titleRequire;
    private String titleDescribe;
    private String teacherNo;
    private String admission;  //录取情况：0未选，1已选
    private String limitNum;  //限额人数

    public String getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleRequire() {
        return titleRequire;
    }

    public void setTitleRequire(String titleRequire) {
        this.titleRequire = titleRequire;
    }

    public String getTitleDescribe() {
        return titleDescribe;
    }

    public void setTitleDescribe(String titleDescribe) {
        this.titleDescribe = titleDescribe;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }


    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(String limitNum) {
        this.limitNum = limitNum;
    }
}
