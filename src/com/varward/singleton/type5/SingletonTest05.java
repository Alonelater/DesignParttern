package com.varward.singleton.type5;


/**
 * 单例模式共有八种写法
 *  单例设计模式八种方式
 * 单例模式有八种方式：
 * 1) 饿汉式(静态常量)     完成
 * 2) 饿汉式（静态代码块）   完成
 * 3) 懒汉式(线程不安全)
 * 4) 懒汉式(线程安全，同步方法)
 * <p>
 * 5) 双重检查
 * 6） 静态内部类
 * 7) 枚举
 * 现在我们介绍单例模式的第6种写法
 */
public class SingletonTest05 {

    public static void main(String[] args) {
        System.out.println("采用静态内部类实现单例模式");
        //测试 下面我们已经写好了单例模式的第一种懒汉式 我们先来测试一下是否是只创建了一个实例对象
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println("比较两个实例对象是否是同一个，结果是：" + (instance == instance2));
        System.out.println("输出两个实例对象的hashcode：" + instance.hashCode());
        System.out.println("输出两个实例对象的hashcode：" + instance2.hashCode());

    }

}

class Singleton {

    //构造器私有化
    private Singleton() {

    }

    //使用静态内部类创建实力对象
    // 1) 这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
    //2) 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化 时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的 实例化。
    //3) 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们 保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
    //4) 优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
    //5) 结论：推荐使用.
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外提供共有方法获得实例对象
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }


}
