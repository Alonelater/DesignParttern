package com.varward.simplefactory.type1;

/**
 *
 *
 * 现在有一个顾客上门来开始订购pizza  那我就要让这个pizza店直接将我们从pizza制作的地方拿来pizza直接给顾客
 *相当于这个pizza这个店  是只披萨 怎么做的他不知道 他就知道拿货
 */
public class PizzaStore {
    public static void main(String[] args) throws NoSuchFieldException {
        OrderPizza orderPizza = new OrderPizza();
        Pizza pizza = orderPizza.orderPizza();

    }

    //问题
    //传统的方式的优缺点
    //1) 优点是比较好理解，简单易操作。
    // 2) 缺点是违反了设计模式的ocp原则，即对扩展开放，对修改关闭。即当我们给类增 加新功能的时候，尽量不修改代码，或者尽可能少修改代码.
    // 3) 比如我们这时要新增加一个Pizza的种类(Bananer披萨)，我们需要做如下修改.

}
