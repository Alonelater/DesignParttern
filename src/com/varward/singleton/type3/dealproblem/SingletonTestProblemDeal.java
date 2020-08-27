package com.varward.singleton.type3.dealproblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTestProblemDeal {
    public static void main(String[] args) {

        //生成线程池最大20个并发线程
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i= 0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----->"+ Sington.getInstance());
                }
            });
        }

        executorService.shutdown();



        //从前面来看的出来   所以证明懒汉式是有线程安全问题的  现在这个例子就是在一定程度上解决了懒汉式的线程安全问题的
        //我们一起看一下 方法就是在对外的方法上加锁

        //通过多次的打印结果 我们发现确实是可以解决懒加载存在的线程安全问题
        /**
         *
         * pool-1-thread-1----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-20----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-19----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-18----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-17----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-16----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-15----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-14----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-13----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-12----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-4----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-3----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-2----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-9----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-7----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-5----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-11----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-8----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-10----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         * pool-1-thread-6----->com.atguigu.singleton.type3.dealproblem.Sington@42ab3a06
         */


        //优缺点：
        //1) 解决了线程不安全问题
        //2) 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
        //      而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例， 直接return就行了。方法进行同步效率太低
        // 3) 结论：在实际开发中，不推荐使用这种方式

    }
}


class  Sington{
    //私有化构造器
    private Sington(){

    }
    //声明变量
    private static Sington instance;

    //在方法上加了把锁  使得线程安全
    public static synchronized Sington getInstance(){
        //在判断之前 我们先创建一个环境 让这个多并发可能会发生  我们获取的时候就让他谁上一秒钟 这样如果有两个线程进来 可能先进来的睡着了 所有后进来的判断
        //此时还没有实例对象 那我就自己创建一个 这样第一个睡眠时间已经到了 接着往下执行 可能也会因为其他的在睡眠 没有得到实例  从而造成了两个实例对象不一样
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (instance==null){
            instance = new Sington();
        }
        return instance;
    }
}
