package com.varward.bridge.improve;

public class Client {
    public static void main(String[] args) {
        //创建具体的实现对象  也就是实现方式 就只有一个发送消息的方法  不同的方式使用不同的发送
        MessageImplementor impl = new MessageSMS();
        //创建普通消息对象
        AbstractMessage message = new  CommonMessage(impl);
        message.sendMessage("加班申请速批","李总");

        //将实现方式切换成邮件，再次发送
        MessageImplementor impl1 = new MessageEmail();
        //创建加急消息对象
        AbstractMessage message1 = new UrgencyMessage(impl);
        message.sendMessage("加班申请速批","李总");
        ((UrgencyMessage)message1).watch("111111111111111");




        // 比如我们现在增加一种信封的方式 只需要继承MessageImplementor  然后说明是怎么用信封实现发送信息的
        //public class XinFengMessage implements MessageImplementor
        MessageImplementor impl3 = new XinFengMessage();
        //然后这个信封这种方式是不是加急的 还是普通的
        //创建普通消息对象  或者创建
        AbstractMessage message3 = new  CommonMessage(impl3);
        message3.sendMessage("加班申请速批","李总");

    }
}
