package com.varward.simplefactory.type1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//这是一个制作专门披萨的类
public class OrderPizza {

    //这是一个普通方法帮我们制作我们要的披萨
    String name = getType();
    public Pizza orderPizza() throws NoSuchFieldException {
        if("奶酪".equals(name)){

            GreekPizza greekPizza = new GreekPizza("奶酪披萨");
            greekPizza.prepare();
            greekPizza.bake();
            greekPizza.cut();
            greekPizza.box();
            return greekPizza;

        }else if("芝士".equals(name)){
            CheesePizza cheesePizza = new CheesePizza("芝士披萨");

            cheesePizza.prepare();
            cheesePizza.bake();
            cheesePizza.cut();
            cheesePizza.box();
            return cheesePizza;

        }
        return null;
    }

    private String getType()  {
        String s = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入定制pizza的种类:");
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
