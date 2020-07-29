package com.varward.buildpattern;

/**
 *
 * 现在相当于客户要来买车了 告诉了你需求  你直接立马定制一款客户要的车给他就行了
 * 客户不需要知道细节 只要拿到他想要的车
 */
public class Client {
    public static void main(String[] args) {
        //客户来了  告诉导演我要一个纯金轮毂。粉色车门，德国造的发动机的奔驰车 ，所以现在导演安排
        //首先需要一辆奔驰车
        BuildCar benchiCar = new BenChiCar();

        Director director = new Director(benchiCar);
        //开始告诉下面造车

        Car car = director.constuctCar("纯金", "粉红", "德国牌");
        System.out.println(car);


        //客户来了  告诉导演我要一个纯金轮毂。粉色车门，德国造的发动机的奔驰车 ，所以现在导演安排
        //首先需要一辆奔驰车
        BuildCar bmwCar = new BMWCar();

        Director director1 = new Director(bmwCar);
        //开始告诉下面造车

        Car car1 = director1.constuctCar("纯钢", "黑色", "中国牌");
        System.out.println(car1);



    }
}
