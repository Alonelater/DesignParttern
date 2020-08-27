package com.varward.principle.interfacesegregation;


public interface Inteface1 {
    void method1();

    void method2();

    void method3();

    void method4();

    void method5();
}


class B implements Inteface1 {

    @Override
    public void method1() {
        System.out.println("B实现了大接口中的方法1");
        System.out.println("这也是A将通过依赖B，得到B实现接口中的方法1");
    }

    @Override
    public void method2() {
        System.out.println("B实现了大接口中的方法2");
        System.out.println("这也是A将通过依赖B，得到B实现接口中的方法2");

    }

    @Override
    public void method3() {
        System.out.println("B实现了大接口中的方法3");
        System.out.println("这也是A将通过依赖B，得到B实现接口中的方法3");

    }

    @Override
    public void method4() {
        System.out.println("B实现了大接口中的方法4");
    }

    @Override
    public void method5() {
        System.out.println("B实现了大接口中的方法5");
    }
}

class D implements Inteface1 {

    @Override
    public void method1() {
        System.out.println("D实现了大接口中的方法1");
        System.out.println("这也是C将通过依赖D，得到D实现接口中的方法1");

    }

    @Override
    public void method2() {
        System.out.println("D实现了大接口中的方法2");
    }

    @Override
    public void method3() {
        System.out.println("D实现了大接口中的方法3");
    }

    @Override
    public void method4() {
        System.out.println("D实现了大接口中的方法4");
        System.out.println("这也是C将通过依赖D，得到D实现接口中的方法4");

    }

    @Override
    public void method5() {
        System.out.println("D实现了大接口中的方法5");
        System.out.println("这也是C将通过依赖D，得到D实现接口中的方法5");

    }
}