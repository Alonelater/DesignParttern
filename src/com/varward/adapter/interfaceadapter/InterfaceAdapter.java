package com.varward.adapter.interfaceadapter;

public class InterfaceAdapter  {
    public static void main(String[] args) {
        AbsInterface abs = new AbsInterface() {
            @Override
            public void m1() {
                System.out.println("重写后的m1方法");
            }
        };
        //调用重写的方法1
        abs.m1();

    }
}
