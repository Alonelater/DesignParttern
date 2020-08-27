package com.varward.simplefactory.type3;



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
        //我们通过传入一个工厂 我们的制作奶酪的认为交给工厂 我们只要保证我们的OrderPizza 去拿货 然后披萨的专卖店也是拿货
        //这样就只要改一处就行了  就不用改很多的OrderPizza  这个类了  这就是简单工厂模式
        OrderPizza orderPizza = new OrderPizza(new SimpleFactory());
        //开始制作pizza


    }

}
