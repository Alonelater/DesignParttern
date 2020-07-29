package com.varward.buildpattern;

public class Car {
    //这就是我们的产品类 也就是建造者模式中的Product这个角色

    //首先我们明白一辆车必须拥有车轮、车门、>发动机、方向盘等等 我们随便举几个
    private String carWheel;
    private String carDoor;
    private String carEngine;

    public String getCarWheel() {
        return carWheel;
    }

    public void setCarWheel(String carWheel) {
        this.carWheel = carWheel;
    }

    public String getCarDoor() {
        return carDoor;
    }

    public void setCarDoor(String carDoor) {
        this.carDoor = carDoor;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carWheel='" + carWheel + '\'' +
                ", carDoor='" + carDoor + '\'' +
                ", carEngine='" + carEngine + '\'' +
                '}';
    }
}
