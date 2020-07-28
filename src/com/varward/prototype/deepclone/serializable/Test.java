package com.varward.prototype.deepclone.serializable;

public class Test {
    public static void main(String[] args) throws Exception {
        TeacherSer teacher = new TeacherSer();
        teacher.setAge(23);
        teacher.setName("校花");

        StudentSer student = new StudentSer();
        student.setAge(50);
        student.setName("赵六");
        student.setTeacherSer(teacher);

        StudentSer ss = (StudentSer) student.deepCopy();

        System.out.println(ss+""+ ss.hashCode());


        System.out.println("---------------------");
        System.out.println(ss.getTeacherSer().getAge());
        System.out.println(ss.getTeacherSer().getName());

        System.out.println("-----------------------");

        ss.getTeacherSer().setAge(7777);
        ss.getTeacherSer().setName("hhhhh");

        System.out.println(teacher.getAge());
        System.out.println(teacher.getName());
        //虽然上面的已经改了，但是改的是那个复制对象后的那个里面的，然后那个原来的那个里面的并没有改，下面验证：：：

        System.out.println("-----------------");

        System.out.println(ss.getTeacherSer().getAge());
        System.out.println(ss.getTeacherSer().getName());


    }

}
