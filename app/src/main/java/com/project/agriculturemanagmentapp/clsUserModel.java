package com.project.agriculturemanagmentapp;

public class clsUserModel {
    String uname;
    String mo;
    String url;

    public clsUserModel(String uname, String mo, String url) {
        this.uname = uname;
        this.mo = mo;
        this.url = url;
    }

    public clsUserModel(String uname, String mo) {
        this.uname = uname;
        this.mo = mo;
    }

    public clsUserModel() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
