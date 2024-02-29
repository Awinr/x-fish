package com.aaron.designPattern;

import org.springframework.stereotype.Component;

@Component("BankPay")
public class BankPayHandler implements PayHandler{
    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.BANK_PAY;
    }

    @Override
    public void pay() {
        System.out.println("银行卡支付");
    }
}
