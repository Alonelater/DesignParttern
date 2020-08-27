package com.varward.principle.dependenceinversion;

/**
 * 下面介绍依赖倒转原则
 * 1) 高层模块不应该依赖低层模块，二者都应该依赖其抽象
 * 2) 抽象不应该依赖细节，细节应该依赖抽象
 * 3) 依赖倒转(倒置)的中心思想是面向接口编程
 * 4) 依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要稳定的 多。以抽象为基础搭建的架构比以细节为基础的架构要稳定的多。在java中，抽象 指的是接口或抽象类，细节就是具体的实现类
 * 5) 使用接口或抽象类的目的是制定好规范，而不涉及任何具体的操作，把展现细节的 任务交给他们的实现类去完成
 * 模拟场景
 * 请编程完成Person（用户） 接收消息 的功能。
 */
public class DependenceInversion {
    public static void main(String[] args) {


        //由于上面的需求是用户接收消息  所以下面的需求设计是能够完成的

        Person person = new Person();
        String message = person.receiveMessage(new Email());
        System.out.println(message);
        //可是这样会面临一个问题 只能接收Email的消息 不能就收来自微信 qq等其他的消息
        // 如果要接收其他来自微信 qq的就要重新添加微信类 qq类 而且person就要重新设计方法了
        // 所以我们需要改进方案
        //根据上面的依赖倒转原则 我们应该面向接口编程 制定规范 不应该制定细节 而不涉及任何具体的操作，把展现细节的 任务交给他们的实现类去完成
        //所以我们改进下面的方案
    }

}

class Email {

    public String getMessage(){
        return "这是用户接收的电子邮件消息";
    }
}


//首先准备一个用户类
class Person {
    public String receiveMessage(Email email) {
        return email.getMessage();
    }
}
