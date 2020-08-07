package com.varward.adapter.objectadapter;
//假设这就是我们的国外的电压  我们现在国内的手机要充电 但是必须只能通过220V的转换成5V的直流电进行充电 所以我们先要得到这个国外的电压然后进行操作适配成我们需要的

public class Voltage200V {

    public int outPut200V(){
        int src=220;
        System.out.println("这是国外的电压，大小为"+src);
        return src;
    }
}
