package com.varward.principle.interfacesegregation;

public class C {//A类通过Inteface1 使用D类它实现的接口中的145，同时只会使用到145方法

    //根据上面的场景模拟出实现D需要实现的3个方法
    public void depend1(Inteface1 i) {
        i.method1();
    }

    public void depend4(Inteface1 i) {
        i.method4();
    }

    public void depend5(Inteface1 i) {
        i.method5();
    }
}