package com.varward.principle.singleresponsibility;

/**
 *
 * 首写这个类就是介绍设计模式遵守的七大原则之一的
 * 单一职责原则
 * 基本介绍
 * 对类来说的，即一个类应该只负责一项职责。如类A负责两个不同职责：职责1，职责2。
 * 当职责1需求变更而改变A时，可能造成职责2执行错误，所以需要将类A的粒度分解为 A1，A2
 */

/**
 *
 * 首先先模拟一个场景 用来描述单一职责原则的用法
 * 比如现在有一个交通工具类Vehicle  用来描述在陆地上行驶的
 *
 */
public class SingleResponsbility {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("小轿车");
        vehicle.run("飞机");
        //通过生活中的事情发现 我们在设计这个类的时候对于前面的交通工具是比较便利的  但是如果是飞机就显得不是那么恰当了
        //于是就引出了单一职责原则 这个原则就是在一定程度上一个类在设计上应该有自己独立的设计，应该做自己的事 不应该被别的事情所干扰
//        所以我们就要改进我们设计的这个类 仔细看第二个版本SingleResponsbility2
    }


}


class  Vehicle{
    void run(String vehicle){
        System.out.println(vehicle+"在公路上跑");
    }
}
