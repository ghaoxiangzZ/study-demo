package com.demo;

import com.demo.designmode.designmode1.enums.VipEnum;
import com.demo.designmode.designmode1.factory.VipFactory;
import com.demo.designmode.designmode1.strategy.VipStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName ModifyIfElseTest.java
 * @Description 用策略模式+工厂类去除if-else实践
 * @createTime 2020年03月21日 13:57:00
 */
@SpringBootTest
public class ModifyIfElseTest {

    @Test
    public void ModifyIfElseTest() {
        BigDecimal payAmt = new BigDecimal("200");
        VipStrategy strategy = VipFactory.getVipStrategyByType(VipEnum.YEARLY_VIP.getVipType());
        System.out.println(strategy.vipAmount(payAmt));
    }
}
