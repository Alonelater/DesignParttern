package com.varward.adapter.objectadapter;



public class Client {
    public static void main(String[] args) {
        //下面我们开始测试我们的对象适配器有没有用


       ObjectAdapter objectAdapter = new ObjectAdapter(new Voltage200V());
        int change = objectAdapter.change();
        if (change==5){
            System.out.println("转换正常，正在开始给手机充电");
        }else {
            System.out.println("充电异常，请更换转接头");
        }
    }
}
