package com.register.entity;

public class User {
    private String userNo;
    private String password;
    private String userName;
    private String identity;
    private String ipAddress;
    private String loginTime;

    public User() {
    }

    public User(String userNo, String password, String userName, String identity, String ipAddress, String loginTime) {
        this.userNo = userNo;
        this.password = password;
        this.userName = userName;
        this.identity = identity;
        this.ipAddress = ipAddress;
        this.loginTime = loginTime;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
