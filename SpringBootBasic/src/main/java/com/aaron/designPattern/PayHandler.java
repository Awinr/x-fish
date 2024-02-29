package com.aaron.designPattern;

public interface PayHandler {
    PayChannelEnum getChannel();
    void pay();
}
