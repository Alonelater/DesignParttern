package com.varward.principle.liskovsubstitution;

/**
 * 现在我们进行描述一下里氏替换原则  这里对于里氏替换原则 更多的是一种约定 主要的是思想 就和后面的开闭原则
 * 我们简单介绍一下里氏替换原则
 * 基本介绍
 * 如果对每个类型为T1的对象o1，都有类型为T2的对象o2，使得以T1定义的所有程序 P在所有的对象o1都代换成o2时，程序P的行为没有发生变化，
 * 那么类型T2是类型T1 的子类型。换句话说，所有引用基类的地方必须能透明地使用其子类的对象。
 */
public class LiskovSubstitution {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");

        //由于不知道已经重新实现了A类的fun1方法 所以就以为还是原来的减法 这就会出错
        //我们发现原来运行正常的相减功能发生了错误。原因就是类B无意中重写了父类的 方法，造成原有功能出现错误。
        //在实际编程中，我们常常会通过重写父类的方法完 成新的功能，这样写起来虽然简单，但整个继承体系的复用性会比较差。
        //特别是运 行多态比较频繁的时候
        //所以我们现在要进行解决这种错误 所以我们现在用里式替换原则进行改进
        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

//首先准备两个类
class A {//实现求两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {//B继承了A  但是假装不知道重新实现了里面A类中的fun1方法  并且还实现了新的方法 也就是fun2这个方法
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}

