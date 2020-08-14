package com.varward.bridge;
//邮件消息示例类
public class EmailMessage implements Message {
    @Override
    public void send(String message, String toUser) {

        System.out.println("使用邮件短消息的方法，发送邮件消息'"+message+"'给"+toUser);
    }
}
