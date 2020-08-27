package com.varward.principle.interfacesegregation;
//由于现在接口已经被拆分了  所以我们A方法中的接口已经不再是全部是原来的Interface1了
public class StrongA {

    //根据上面的场景模拟出实现A需要实现接口InterfaceStrong1的1个方法，还有InterfaceStrong23中的两个方法
    public void depend1(InterfaceStrong1 i) {
        i.method1();
    }

    public void depend2(InterfaceStrong23 i) {
        i.method2();
    }

    public void depend3(InterfaceStrong23 i) {
        i.method3();
    }
}
