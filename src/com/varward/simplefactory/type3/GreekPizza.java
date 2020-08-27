package com.varward.simplefactory.type3;

//具体的披萨
public class GreekPizza implements Pizza {


    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public GreekPizza(String name){
        this.name = name;
    }


    @Override
    public void prepare() {
        System.out.println("奶酪披萨准备中");
    }

    @Override
    public void bake() {
        System.out.println("奶酪披萨烘焙中");

    }

    @Override
    public void cut() {
        System.out.println("奶酪披萨切割中");

    }

    @Override
    public void box() {
        System.out.println("奶酪披萨打包中");

    }
}
