package com.example.EmployeeWebApp.Model.javabean;

public class EmployeeSummary {
    private Long id;
    private String nickname;
    private String fullname;
    private String age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeSummary{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
