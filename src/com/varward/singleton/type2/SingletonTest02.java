package com.varward.singleton.type2;

/**
 * 单例模式共有八种写法
 *  单例设计模式八种方式
 * 单例模式有八种方式：
 * 1) 饿汉式(静态常量)     完成
 * 2) 饿汉式（静态代码块）   完成
 * 3) 懒汉式(线程不安全)
 * 4) 懒汉式(线程安全，同步方法)
 * 5) 懒汉式(线程安全，同步代码块)
 * 6) 双重检查
 * 7) 静态内部类
 * 8) 枚举
 * 现在我们介绍单例模式的第二种写法  也就是单例模式中的饿汉式  这个是通过静态代码块实现的  写完之后介绍一下有什么优缺点
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        System.out.println("采用饿汉式中的静态代码块实现单例模式");
        //测试 下面我们已经写好了单例模式的第二种饿汉式 我们先来测试一下是否是只创建了一个实例对象
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println("比较两个实例对象是否是同一个，结果是：" + (instance == instance2));
        System.out.println("输出两个实例对象的hashcode：" + instance.hashCode());
        System.out.println("输出两个实例对象的hashcode：" + instance2.hashCode());

        //根据上面测试  两个对象是同一个
        // 下面介绍另一个饿汉式 只不多是用静态代码块的方式完成的   其实思想差不多 我们看一下type2
    }

}

//首先明白什么是饿汉式 饿汉式指的就是当类创建时就已经创建出来 而不是等到想用的时候才创建
//单例模式 顾名思义就是整个项目中只有一个对象 所有的对象都是一个 不能出现第二个
class Singleton {
    //为了保证别人不能直接new Singleton 来创建对象 所以我们就首先将构造器私有化 这样别人就不能直接new了
    private Singleton() {

    }

    //别人要使用这个对象我们只要负责提供方法 让他接收就行了  要接收我们就写创建好这个对象
    //我们先声明这个实例对象  然后通过静态代码块帮我们实现赋值 我们要保证这个类是只有独一份的 所以我们用static修饰  既能保证这个对象是只有一份
    private  static Singleton instance;

    static {
        instance = new Singleton();
    }

    //对外提供一个静态方法使得别人能够获得当前这个单例对象
    public static Singleton getInstance() {
        return instance;
    }


    //总结单例模式之饿汉式有什么优缺点
    //优缺点说明：
    //1) 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。  因为一加载就被创建出来了 哪里还会有线程问题
    //2) 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始 至终从未使用过这个实例，则会造成内存的浪费
    //3) 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载 时就实例化，在单例模式中大多数都是调用getInstance方法， 但是导致类装载 的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类 装载，这时候初始化instance就没有达到lazy loading的效果
    //4) 结论：这种单例模式可用，可能造成内存浪费


}
