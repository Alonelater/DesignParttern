package com.varward.simplefactory.type1;

//今天要设计的是工厂模式里面的第一个简单工厂模式
//我们先看一下模拟案例的需求
//看一个具体的需求
//看一个披萨的项目：要便于披萨种类的扩展，要便于维护
//      1) 披萨的种类很多(比如 GreekPizz、CheesePizz 等)
//      2) 披萨的制作有 prepare，bake, cut, box
//      3) 完成披萨店订购功能。
public interface Pizza {
    //首先我们知道每个披萨都得有准备，烘焙，裁剪，打包等等阶段 所以这些就是制作披萨的具体方法 所以我们具体的类都要实现这些方法
    //所以我们将他放在接口里面  只要具体的类继承就行了
    void prepare();
    void bake();
    void cut();
    void box();
}
