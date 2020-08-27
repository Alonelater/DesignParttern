package com.varward.simplefactory.type3;

//这是一个制作专门披萨的类
public class OrderPizza {

   private SimpleFactory simpleFactory;
   public OrderPizza(SimpleFactory simpleFactory){
       this.simpleFactory = simpleFactory;
       try {
           simpleFactory.orderPizza();
       } catch (NoSuchFieldException e) {
           e.printStackTrace();
       }

   }

    public SimpleFactory getSimpleFactory() {
        return simpleFactory;
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }
}
