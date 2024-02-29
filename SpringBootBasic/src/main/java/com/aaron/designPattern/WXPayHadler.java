package com.aaron.designPattern;

import org.springframework.stereotype.Component;

@Component("WXPay")
public class WXPayHadler implements PayHandler {
    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.WX_PAY;
    }

    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
