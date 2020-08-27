package com.varward.singleton.type6;

public class SingtonTest06 {
    public static void main(String[] args) {
        System.out.println("采用枚举实现单例模式");
        //测试 下面我们已经写好了单例模式的第一种懒汉式 我们先来测试一下是否是只创建了一个实例对象
        Singleton instance = Singleton.INSTANCE;//两种方式都行
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance);//这里输出的不再是内存地址  而是两个INSTANCE
        System.out.println(instance2);//这里输出的不再是内存地址  而是两个INSTANCE
        System.out.println("比较两个实例对象是否是同一个，结果是：" + (instance == instance2));
        System.out.println("输出两个实例对象的hashcode：" + instance.hashCode());
        System.out.println("输出两个实例对象的hashcode：" + instance2.hashCode());
    }
}

enum  Singleton{
    INSTANCE;//属性 其实是
    public static Singleton getInstance(){
        return INSTANCE;
    }
    //优缺点说明：
        //1) 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而 且还能防止反序列化重新创建新的对象。
        //2) 这种方式是Effective Java作者Josh Bloch 提倡的方式
        //3) 结论：推荐使用
}