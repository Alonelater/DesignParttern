package com.varward.prototype.deepclone.clone;

public class Student implements Cloneable {

    private String name ;
    private int classes;
    private Integer age;
    private Teacher teacher;

    public Student(String name, int classes, Integer age, Teacher teacher) {
        this.name = name;
        this.classes = classes;
        this.age = age;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes=" + classes +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //由于这里有基本数据类型还有teacher这个引用数据类型 所以我们在克隆的时候要分开来克隆

        //这里只是进行了浅克隆
        Student student = (Student) super.clone();
        //接下来进行深克隆 就是将引用类型也进行克隆  就是要分开克隆
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
