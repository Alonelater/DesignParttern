package com.varward.singleton.type3;

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
 * 现在我们介绍单例模式的第三种写法  也就是单例模式中的懒汉式 写完之后介绍一下有什么优缺点
 */
public class SingletonTest03{
    public static void main(String[] args) {
        System.out.println("采用懒汉式实现单例模式，但是会造成线程安全问题");
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
    //我们先声明这个实例对象 这里不能用final修饰  因为final修饰的一定要赋初值  你这里直接通过判断才给初始值 编译通不过去

    private  static Singleton instance;



    //对外提供一个静态方法使得别人能够获得当前这个单例对象  如果此时没有的话我们就new一个 有我们就直接返回
    public static Singleton getInstance() {
        if (instance==null){
            instance=new Singleton();
        }

        return instance;
    }


    //总结单例模式之懒汉式有什么优缺点
    //优缺点说明：
    //1) 起到了Lazy Loading的效果，但是只能在单线程下使用。
    //2) 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及 往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以 在多线程环境下不可使用这种方式
    //3) 结论：在实际开发中，不要使用这种方式.

    //现在我们模拟这个多线程并发访问  看看会不会产生多个实例


}
