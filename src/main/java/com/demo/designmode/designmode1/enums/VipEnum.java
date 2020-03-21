package com.demo.designmode.designmode1.enums;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName VipEnum.java
 * @Description TODO
 * @createTime 2020年03月21日 13:11:00
 */
public enum VipEnum {

    YEARLY_VIP(1),
    MONTHLY_VIP(2),
    NON_VIP(3);

    private int vipType;

    VipEnum(int vipType) {
        this.vipType = vipType;
    }

    public int getVipType() {
        return vipType;
    }
}
