package com.varward.principle.singleresponsibility;

/**

/**
 *
 * 首先先模拟一个场景 用来描述单一职责原则的用法
 * 比如现在有一个交通工具类Vehicle  用来描述在陆地上行驶的
 *
 * 这个类是1的改良版
 *
 */
public class SingleResponsbility2 {

    public static void main(String[] args) {

        RoadVehicle vehicle = new RoadVehicle();
        vehicle.run("摩托车");
        vehicle.run("轮船");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
        //通过上面的分析发现每个类应该有自己独立的事  不应该将所有的事都交给一个人 这样会有很多问题产生 于是诞生了第二个版本
        //这个版本将1的版本里面的Vehicle拆成了三部分 这样有好有坏 解决了1存在的麻烦 但是带来了花销 就是设计的类太多了
        //每次有新的需需求就要创建一个类
        //下面引进第三个版本

    }


}


class  RoadVehicle{
    void run(String vehicle){
        System.out.println(vehicle+"在公路上跑");
    }
}

class  WaterVehicle{
    void run(String vehicle){
        System.out.println(vehicle+"在水中行驶");
    }
}

class  AirVehicle{
    void run(String vehicle){
        System.out.println(vehicle+"在天空中飞行");
    }
}