package com.varward.prototype.improve;

/**
 * 现在模拟原型链模式  这个模式主要用这个案例 就是我们要克隆10只一模一样的羊
 */


public class Test {

    public static void main(String[] args) {

       //开始克隆




        //优点就是比较容易想到  简单操作
        //缺点就是创建新的对象时总是需要getXXX  就是需要去时时刻刻拿  万一有一百个 你要get一百次


        Sheep sheep = new Sheep("大羊肖恩", 20, "白色");

        //这个的好处在于  我们加入羊多了个属性 我们就不用改那么多地方的getXXX  只要更改第一只羊的属性就行了

        //现在我们实现了克隆接口的进行克隆

        Sheep sheep1= (Sheep) sheep.clone();
        Sheep sheep2= (Sheep) sheep.clone();
        Sheep sheep3= (Sheep) sheep.clone();
        Sheep sheep4= (Sheep) sheep.clone();
        Sheep sheep5= (Sheep) sheep.clone();
        System.out.println(sheep1+""+sheep1.hashCode());
        System.out.println(sheep2+""+sheep2.hashCode());
        System.out.println(sheep3+""+sheep3.hashCode());
        System.out.println(sheep4+""+sheep4.hashCode());
        System.out.println(sheep5+""+sheep5.hashCode());




    }

}
