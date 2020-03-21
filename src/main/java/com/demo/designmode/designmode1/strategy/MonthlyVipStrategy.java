package com.demo.designmode.designmode1.strategy;

import com.demo.designmode.designmode1.enums.VipEnum;
import com.demo.designmode.designmode1.factory.VipFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MonthlyVipServiceImpl.java
 * @Description 包月vip服务
 * @createTime 2020年03月21日 13:01:00
 */
@Service
public class MonthlyVipStrategy implements VipStrategy {

    @Override
    public BigDecimal vipAmount(BigDecimal initialAmt) {
        return initialAmt.multiply(new BigDecimal("0.75"));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        VipFactory.register(VipEnum.MONTHLY_VIP.getVipType(), this);
    }
}
