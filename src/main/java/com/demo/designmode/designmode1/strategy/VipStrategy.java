package com.demo.designmode.designmode1.strategy;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName VipService.java
 * @Description vip基础服务
 * @createTime 2020年03月21日 12:58:00
 */
public interface VipStrategy extends InitializingBean {

    BigDecimal vipAmount(BigDecimal initialAmt);
}
