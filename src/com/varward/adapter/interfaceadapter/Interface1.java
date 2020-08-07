package com.varward.adapter.interfaceadapter;

/**
 *
 *
 * 下面我们介绍接口适配器的用法 就说我们有一个接口 但是里面的方法我们会用一个抽象的类进行全部的空实现 等待子类需要什么方法再重写就行了
 * 典型的用在
 * 缺省适配器模式(Default Adapter Pattern)：
 * 当不需要实现一个接口所提供的所有方法时，可先设计一个抽象类实现该接口，并为接口中每个方法提供一个默认实现（空方法），那么该抽象类的子类可以选择性地覆盖父类的某些方法来实现需求，
 * 它适用于不想使用一个接口中的所有方法的情况，又称为单接口适配器模式。缺省适配器模式是适配器模式的一种变体，其应用也较为广泛。
 * 在JDK类库的事件处理包java.awt.event中广泛使用了缺省适配器模式，如WindowAdapter、KeyAdapter、MouseAdapter等。
 */
public interface Interface1 {
    void m1();
    void m2();
    void m3();
    void m4();
}
