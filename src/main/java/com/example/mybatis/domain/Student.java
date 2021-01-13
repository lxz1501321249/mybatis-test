package com.example.mybatis.domain;


public class Student {
    private Integer id;
    private Sex sex;
    private String name;

    public Student() {
    }

    public Student(Integer id, Sex sex, String name) {
        this.id = id;
        this.sex = sex;
        this.name = name;
    }

    public Student(String name, Sex sex) {
        this.sex = sex;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }
}
