package com.demo.designmode.designmode.strategy;

import com.demo.designmode.designmode.enums.VipEnum;
import com.demo.designmode.designmode.factory.VipFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName NonVipServiceImpl.java
 * @Description 非会员服务
 * @createTime 2020年03月21日 13:05:00
 */
@Service
public class NonVipStrategy implements VipStrategy {

    @Override
    public BigDecimal vipAmount(BigDecimal initialAmt) {
        return initialAmt;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        VipFactory.register(VipEnum.NON_VIP.getVipType(), this);
    }
}
