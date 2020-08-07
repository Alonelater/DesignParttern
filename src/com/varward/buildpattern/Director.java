package com.varward.buildpattern;

/**
 *
 * 这就是导演类 就是统筹全盘计划的  指挥所有的事情能够顺利进行
 *
 * Director 导演类，负责安排已有模块的顺序，然后告诉 Builder 开始建造。
 *
 */
public class Director {

    //这个导演就是相当于有一个包工头 包工头下面有一群小弟 每个小弟干自己的活  现在包工头告诉导演一切准备就绪 可以开工
    //就等导演指示  然后导演收到客人的需求 开始指示

    private BuildCar buildCar= null;
    public Director(BuildCar buildCar){
        this.buildCar = buildCar;
    }


    //开始建造车
    public Car constuctCar(String wheel,String color,String engine){
        buildCar.bulidCarWheel(wheel);
        buildCar.bulidCarDoor(color);
        buildCar.bulidCarEngine(engine);
        Car car = buildCar.creatCar();
        return car;
    }

}
