package com.varward.principle.singleresponsibility;

/**

 定义：
 对类来说的，即一个类应该只负责一项职责。如类A负责两个不同职责：职责1，职责2。
 当职责1需求变更而改变A时，可能造成职责2执行错误，所以需要将类A的粒度分解为 A1，A2


 /**
 *
 * 首先先模拟一个场景 用来描述单一职责原则的用法
 * 比如现在有一个交通工具类Vehicle  用来描述在陆地上行驶的
 *
 * 这个类是1，2的改良版
 *
 *
 * 总结：
 *  单一职责原则
 * 单一职责原则注意事项和细节
 * 1) 降低类的复杂度，一个类只负责一项职责。
 * 2) 提高类的可读性，可维护性
 * 3) 降低变更引起的风险
 * 4) 通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违反单一职责原则
 *    只有类中方法数量足够少，可以在方法级别保持单一职责原则
 *
 */
public class SingleResponsbility3 {

    public static void main(String[] args) {

        LastVehicle vehicle = new LastVehicle();
        vehicle.run("摩托车");
        vehicle.run("小轿车");
        vehicle.runAir("飞机");
        //这样就在最终程度上解决了单一职责原则 但是他是在方法的层面上实现了单一职责原则，但是就是不是在类上实现了


    }


}


class  LastVehicle{
    void run(String vehicle){
        System.out.println(vehicle+"在公路上跑");
    }
    void runWater(String vehicle){
        System.out.println(vehicle+"在水中行驶");
    }
    void runAir(String vehicle){
        System.out.println(vehicle+"在天空中飞行");
    }
}

