package com.aaron.designPattern;

public enum PayChannelEnum {
    Ali_PAY(0, "支付宝支付", "AliPay"),
    WX_PAY(1, "微信支付", "WXPay"),
    BANK_PAY(2, "银行卡支付", "BankPay");

    private Integer code;

    private  String desc;

    private String name;

    PayChannelEnum(Integer code, String desc, String name) {
        this.code = code;
        this.desc = desc;
        this.name = name;
    }
    /**
     * 根据code获取枚举
     */
    public static PayChannelEnum getEnumByCode(Integer code) {
        for (PayChannelEnum payChannelEnum : PayChannelEnum.values()) {
            if (payChannelEnum.getCode().equals(code)) {
                return payChannelEnum;
            }
        }
        return null;
    }
    public Integer getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    public String getName() {
        return name;
    }
}
