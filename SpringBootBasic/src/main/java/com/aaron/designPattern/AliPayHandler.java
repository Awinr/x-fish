package com.aaron.designPattern;

import org.springframework.stereotype.Component;

@Component("AliPay")
public class AliPayHandler implements PayHandler {
    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.Ali_PAY;
    }

    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
