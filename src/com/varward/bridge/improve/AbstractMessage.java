package com.varward.bridge.improve;

//这是一个抽象类  也就是桥接类  这个类拥有了具体用什么方式的发送的引用
//说的再简单的 就是我有任何你发信息的方式 无所谓你是邮件 短信息 还是信封  只要我有你的顶级接口就行
//我还定义了一个发送消息，委派给实现部分的方法 这个方法最终目的就是让你告诉我你是什么方式 我好根据你用的方式来进行匹配相应的具体发消息的方式

public abstract class AbstractMessage {


    //其中含有具体实现类的引用 其实就是多态的一种体现

    //持有一个实现部分的对象
    MessageImplementor impl;

    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    /**
     * 发送消息，委派给实现部分的方法
     *
     * @param message 要发送消息的内容
     * @param toUser  消息的接受者
     */
    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }

}
