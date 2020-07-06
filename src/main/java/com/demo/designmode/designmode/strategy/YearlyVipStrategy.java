package com.demo.designmode.designmode.strategy;

import com.demo.designmode.designmode.enums.VipEnum;
import com.demo.designmode.designmode.factory.VipFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName YearlyVipServiceImpl.java
 * @Description 年费vip服务
 * @createTime 2020年03月21日 13:04:00
 */
@Service
public class YearlyVipStrategy implements VipStrategy {

    @Override
    public BigDecimal vipAmount(BigDecimal initialAmt) {
        return initialAmt.multiply(new BigDecimal("0.5"));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        VipFactory.register(VipEnum.YEARLY_VIP.getVipType(), this);
    }
}
