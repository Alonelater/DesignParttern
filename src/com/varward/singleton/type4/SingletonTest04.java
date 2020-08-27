package com.varward.singleton.type4;

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
 * 现在我们介绍单例模式的第五种写法  上面的 第四种写法我已经写在了type3中的dealproblem中了
 */
public class SingletonTest04 {
    public static void main(String[] args) {

        System.out.println("采用懒汉式实现单例模式，问题已经解决");
        //测试 下面我们已经写好了单例模式的第一种懒汉式 我们先来测试一下是否是只创建了一个实例对象
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println("比较两个实例对象是否是同一个，结果是：" + (instance == instance2));
        System.out.println("输出两个实例对象的hashcode：" + instance.hashCode());
        System.out.println("输出两个实例对象的hashcode：" + instance2.hashCode());

        //根据上面测试  两个对象是同一个

    }

}

//首先明白什么是懒汉式  什么是懒汉式 懒就是不用的时候不创建  懒汉式指的就是当需要这个实例对象的时候才去创建出来
//单例模式 顾名思义就是整个项目中只有一个对象 所有的对象都是一个 不能出现第二个
class Singleton {
    //为了保证别人不能直接new Singleton 来创建对象 所以我们就首先将构造器私有化 这样别人就不能直接new了
    private Singleton() {

    }

    //别人要使用这个对象我们只要负责提供方法 让他接收就行了  要接收我们就写创建好这个对象
    //我们先声明这个实例对象 这里不能用final修饰

    //这里一定要加上这个volatile 关键字
    private volatile static Singleton instance;


    //对外提供一个静态方法使得别人能够获得当前这个单例对象  如果此时没有的话我们就new一个 有我们就直接返回
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    //这是使用了双重检查用来解决懒加载问题带来的线程安全问题
    // 第一次同时有两个线程到达getInstance()方法if判断时，其中有一个肯定是阻塞的，
    // 当另外一个执行完以后，阻塞这个线程会因为刚刚那个没有被阻塞的对象已经创建好了对象  所以不会通过第二次的if判断，从而直接返回第一个线程创造的实例对象
    // 此时就算其他线程来了 他们会直接跳过if判断，直接返回single，不会再被锁，执行效率也会很高。
    //所以推荐使用其中 volatile是解决我们不能确定在内存中是先给对象赋值，还是先创建了这个对象，
    // 所以第二个程序有可能得到的是初始化一半了的对象，在jdk1.5之后，我们可以用volatile这个关键字来避免这种情况

}
