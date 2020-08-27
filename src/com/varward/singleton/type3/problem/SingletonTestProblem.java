package com.varward.singleton.type3.problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTestProblem {
    public static void main(String[] args) {


        //用实际的代码模拟出这个线程安全问题


        //生成线程池最大20个并发线程
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i= 0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----->"+Sington.getInstance());
                }
            });
        }

        executorService.shutdown();

        /**
         * 打印结果如下：
         * pool-1-thread-15----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-6----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-7----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-10----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-18----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-19----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-14----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-11----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-1----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-5----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-4----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-8----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-9----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-12----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-13----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         *
         *
         * pool-1-thread-20----->com.atguigu.singleton.type3.problem.Sington@5c51f3bd
         *
         *
         *
         * pool-1-thread-16----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-17----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-2----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         * pool-1-thread-3----->com.atguigu.singleton.type3.problem.Sington@6321d33b
         *
         */

        //从上面看的出来  在第20个线程池中就产生了不一样的实例对象  所以证明懒汉式是有线程安全问题的
        // 之后我们会讲解怎么讲懒汉式解决线程安全问题

    }
}


class  Sington{
    //私有化构造器
    private Sington(){

    }
    //声明变量
    private static Sington instance;

    //提供方法进行获取这个实力对象
    public static  Sington getInstance(){
        //在判断之前 我们先创建一个环境 让这个多并发可能会发生  我们获取的时候就让他谁上一秒钟 这样如果有两个线程进来 可能先进来的睡着了 所有后进来的判断
        //此时还没有实例对象 那我就自己创建一个 这样第一个睡眠时间已经到了 接着往下执行 可能也会因为其他的在睡眠 没有得到实例  从而造成了两个实例对象不一样
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (instance==null){
            instance = new Sington();
        }
        return instance;
    }
}
