package com.example.EmployeeWebApp.Model.javabean;

public class RegisterInfo {
    private String fname;
    private String lname;
    private String address;
    private String gender;
    private String[] qualification;
    private String race;
    private String intro;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getQualification() {
        return qualification;
    }

    public void setQualification(String[] qualification) {
        this.qualification = qualification;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
