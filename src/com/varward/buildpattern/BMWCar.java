package com.varward.buildpattern;


/**
 *
 * 一个具体的类  用于实现建造的细节
 *
 * ConcreteBuilder 具体建造者，实现抽象 Builder 定义的所有方法，并且返回一个组件好的对象。
 *
 */

public class BMWCar extends  BuildCar {


    private Car car = new Car();

    @Override
    void bulidCarWheel(String wheel) {
        car.setCarWheel(wheel);
        System.out.println("宝马车建造中，使用的是"+wheel+"轮毂");
    }

    @Override
    void bulidCarDoor(String color) {
        car.setCarDoor(color);
        System.out.println("宝马车建造中，使用的是"+color+"颜色的门");
    }

    @Override
    void bulidCarEngine(String engine) {
        car.setCarEngine(engine);
        System.out.println("宝马车建造中，使用的是"+engine+"的发动机");
    }

    @Override
    Car creatCar() {
        return car;
    }
}
