package com.varward.buildpattern;

public abstract class BuildCar {
    //这个是我们的Builder 抽象建造者，它是规范产品的组件，一般是由子类实现。所以我们设定成抽象类  用于规定我们产品的制作步骤


    //我们首先要安装轮子  什么材质轮子
    abstract void bulidCarWheel(String wheel);
    //我们首先要安装轮子  什么颜色的车门
    abstract void bulidCarDoor(String color);
    //我们首先要安装轮子  什么牌子的发动机
    abstract void bulidCarEngine(String engine);
    //返回车辆  交给ConcreteBuilder
    abstract Car creatCar();


}
