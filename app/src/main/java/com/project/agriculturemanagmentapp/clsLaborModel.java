package com.project.agriculturemanagmentapp;

public class clsLaborModel {
    String lname,lmo,lloc,lwages,ldes,ldate,key;

    public clsLaborModel(String lname, String lmo, String lloc, String lwages, String ldes, String ldate, String key) {
        this.lname = lname;
        this.lmo = lmo;
        this.lloc = lloc;
        this.lwages = lwages;
        this.ldes = ldes;
        this.ldate = ldate;
        this.key = key;
    }

    public clsLaborModel() {
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLmo() {
        return lmo;
    }

    public void setLmo(String lmo) {
        this.lmo = lmo;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public String getLwages() {
        return lwages;
    }

    public void setLwages(String lwages) {
        this.lwages = lwages;
    }

    public String getLdes() {
        return ldes;
    }

    public void setLdes(String ldes) {
        this.ldes = ldes;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
