package com.varward.adapter.objectadapter;


public class ObjectAdapter implements IVoltage5V{


    //这里我们将不再继承Voltage200V  而是将它作为成员变量
    private Voltage200V voltage200V;

    public ObjectAdapter(Voltage200V voltage200V) {
        this.voltage200V = voltage200V;
    }

    @Override
    public int change() {
        //定义国内电压
        int temp ;
        //获得200V的电压
        int i = voltage200V.outPut200V();
        temp = i+20;
        //经过转化
        int dest = temp/44;
        System.out.println("手机充电电压转换完成");
        return  dest;
    }
}
