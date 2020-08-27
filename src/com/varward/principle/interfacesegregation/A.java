package com.varward.principle.interfacesegregation;

public class A {//A类通过Inteface1 使用B类中他自己实现的123方法，同时只会使用到123方法

    //根据上面的场景模拟出实现A需要实现的3个方法
    public void depend1(Inteface1 i) {
        i.method1();
    }

    public void depend2(Inteface1 i) {
        i.method2();
    }

    public void depend3(Inteface1 i) {
        i.method3();
    }
}