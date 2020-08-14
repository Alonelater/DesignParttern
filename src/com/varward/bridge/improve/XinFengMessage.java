package com.varward.bridge.improve;

public class XinFengMessage implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("信封的发送方式");
    }

}
