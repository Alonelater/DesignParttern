package com.varward.principle.liskovsubstitution.improve;

/**
 * 通过里式替换原则解决上面出现的问题
 *
 *
 * 总结： 通用的做法是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉， 采用依赖，聚合，组合等关系代替.
 */
public class LiskovSubstitutionStrong {
    public static void main(String[] args) {
        AStrong a = new AStrong();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");

        //现在这样改写过后就不会出错了
        BStrong b = new BStrong();
        System.out.println("11+3=" + b.func1(11, 3));
        System.out.println("1+8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

//首先我们定义一个基础类
abstract class Base {
    public abstract int func1(int num1, int num2);
}

//首先准备两个类
class AStrong extends Base {//实现求两个数的差

    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class BStrong extends Base {//B继承了A  但是假装不知道重新实现了里面A类中的fun1方法  并且还实现了新的方法 也就是fun2这个方法

    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}

