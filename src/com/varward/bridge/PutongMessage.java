package com.varward.bridge;
//系统内短消息示例类
public class PutongMessage implements Message {
    @Override
    public void send(String message, String toUser) {

        System.out.println("使用系统内短消息的方法，发送普通消息'"+message+"'给"+toUser);
    }
}
