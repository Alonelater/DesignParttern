package com.varward.adapter.objectadapter;


//这就是我们的目标  就是我们最终通过这个接口帮我们实现转换  就是适配接口 就是核心组件  话句话说就是我们通过转化器内部的组件帮我们将200V的电压转成220V 再转成5V  相当于就是转换器
public interface IVoltage5V {
    //里面定义了一个方法 让其子类具体实现细节
    int change();
}
