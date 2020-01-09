package com.common.Result;

public class Result {
    private boolean flag;
    private int stateCode;
    private String message;
    private Object date;


    public Result(boolean flag, int stateCode, String message, Object date) {
        this.flag = flag;
        this.stateCode = stateCode;
        this.message = message;
        this.date = date;
    }

    public Result(boolean flag, int stateCode, String message) {
        this.flag = flag;
        this.stateCode = stateCode;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
