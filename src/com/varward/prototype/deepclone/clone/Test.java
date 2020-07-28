package com.varward.prototype.deepclone.clone;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher("张三",25);
        Student student = new Student("李四",1,18,teacher);
        Student student2 = (Student) student.clone();
        Student student3 = (Student) student.clone();
        System.out.println(student+""+student.hashCode());
        System.out.println(student2+""+student2.hashCode());
        System.out.println(student3+""+student3.hashCode());

    }
}
