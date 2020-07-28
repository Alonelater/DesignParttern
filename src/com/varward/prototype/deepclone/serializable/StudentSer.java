package com.varward.prototype.deepclone.serializable;

import java.io.*;

public class StudentSer implements Serializable {

    private static final long serialVersionUID = -4013956246460497280L;
    private int age;
    private String name;
    private TeacherSer teacherSer;



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

    public TeacherSer getTeacherSer() {
        return teacherSer;
    }

    public void setTeacherSer(TeacherSer teacherSer) {
        this.teacherSer = teacherSer;
    }


    //由于StudentSer类中有引用是指向的TeacherSer 的  所以有引用也会一起序列化
    //接下来我们将用序列化的方式进行深拷贝
    public Object deepCopy() throws Exception {
        //创建输出流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        //将当前这个对象写到一个输出流当中，，因为这个对象的类实现了Serializable这个接口，所以在这个类中
        //有一个引用，这个引用如果实现了序列化，那么这个也会写到这个输出流当中

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();

    }


    @Override
    public String toString() {
        return "StudentSer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", teacherSer=" + teacherSer +
                '}';
    }
}
