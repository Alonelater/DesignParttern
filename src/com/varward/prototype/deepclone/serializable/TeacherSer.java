package com.varward.prototype.deepclone.serializable;

import java.io.Serializable;

public class TeacherSer implements Serializable {

    private static final long serialVersionUID = 7745204691148074160L;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TeacherSer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
