package com.varward.simplefactory.type2;

/**
 *
 *
 * 现在有一个顾客上门来开始订购pizza  那我就要让这个pizza店直接将我们从pizza制作的地方拿来pizza直接给顾客
 *相当于这个pizza这个店  是只披萨 怎么做的他不知道 他就知道拿货
 *
 * 这个模式的缺点指的是如果你有很多个OrderPizza  那么你就要更改很多的类OrderPizza里面增加的披萨类  每个定制的pizza类都要更改OrderPizza里面的ifelse
 * 这个是相当不好的  所以我们现在引入一个工厂  看看能不能解决问题
 *
 */
public class PizzaStore {
    public static void main(String[] args) throws NoSuchFieldException {
        //创建制作pizza的类
        OrderPizza orderPizza = new OrderPizza();
        //开始制作pizza
        Pizza pizza = orderPizza.orderPizza();

    }

}
