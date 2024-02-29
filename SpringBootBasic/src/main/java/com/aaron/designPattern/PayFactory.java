package com.aaron.designPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("payFactory")
@DependsOn({"BankPay", "AliPay", "WXPay"})
public class PayFactory {

    @Autowired
    private Map<String, PayHandler> payHandlerMap;

    public PayHandler getPayHandler(PayChannelEnum channel) {
        String name = channel.getName();
        return payHandlerMap.get(name);
    }
}
