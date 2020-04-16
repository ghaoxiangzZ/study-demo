package com.demo.designmode.designmode1.factory;

import com.demo.designmode.designmode1.strategy.VipStrategy;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName VipFactory.java
 * @Description 会员工厂类
 * @createTime 2020年03月21日 13:06:00
 */
@Component
public class VipFactory {
    private static ConcurrentHashMap<Integer, VipStrategy> vipStrategyMap = new ConcurrentHashMap<>();

    public static VipStrategy getVipStrategyByType(Integer type) {
        return vipStrategyMap.get(type);
    }

    public static void register(Integer vipType, VipStrategy vipStrategy) {
        vipStrategyMap.put(vipType, vipStrategy);
    }
}
