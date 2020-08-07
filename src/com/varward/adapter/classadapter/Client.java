package com.varward.adapter.classadapter;

public class Client  {
    public static void main(String[] args) {
        //下面我们开始测试我们的类适配器有没有用


        ClassAdapter adapter = new ClassAdapter();
        int change = adapter.change();
        if (change==5){
            System.out.println("转换正常，正在开始给手机充电");
        }else {
            System.out.println("充电异常，请更换转接头");
        }
    }
}
