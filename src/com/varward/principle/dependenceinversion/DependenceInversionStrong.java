package com.varward.principle.dependenceinversion;

/**
 * 为了解决方案1带来的问题 我们现在就制定规范  将细节交给实现类 面向接口编程
 * 我们设计一个MessageReceive接口  让Email也好 微信也好  都去实现这个接口
 */
public class DependenceInversionStrong {
    public static void main(String[] args) {

        //接受来自微信的消息
        WeChat weChat = new WeChat();
        PersonStrong person = new PersonStrong();
        String message = person.getMessage(weChat);
        System.out.println(message);

        //接受来自QQ的消息
        QQ qq = new QQ();
        String message1 = person.getMessage(qq);
        System.out.println(message1);

        //通过测试得知 我们已经实现了用户接收消息的需求 我们还在一定程度上进行了需求扩展
        //仔细想想我们在javaweb也好，ssm项目中也好 我们注入的
        //@Autowired
        //private xxxxService service  不就是在一定程度上实现的面向接口编程 置顶规范  减少模块与模块间的耦合
        //用父类或者接口作为引用传递依赖  实际运行结果看到底是谁实现了这个接口  要仔细想想


        //总结
        //依赖倒转原则的注意事项和细节
        // 1) 低层模块尽量都要有抽象类或接口，或者两者都有，程序稳定性更好.
        // 2) 变量的声明类型尽量是抽象类或接口, 这样我们的变量引用和实际对象间，就存在 一个缓冲层，利于程序扩展和优化
        // 3) 继承时遵循里氏替换原则
    }

}
//由于现在面向接口编程  所以我们就要相应的修改Person（也就是PersonStrong）中的方法

class PersonStrong{
    public String getMessage(MessageReceive messageReceive){
        return messageReceive.getMessage();
    }
}

interface MessageReceive {
    //只有一个设置信息的方法 所有的消息类都要去实现这个方法
    String getMessage();
}

class WeChat implements MessageReceive{

    @Override
    public String getMessage() {
        return "这是来自微信发送的微信消息";
    }
}

class QQ implements MessageReceive{

    @Override
    public String getMessage() {
        return "这是来自QQ发送的QQ消息";
    }
}