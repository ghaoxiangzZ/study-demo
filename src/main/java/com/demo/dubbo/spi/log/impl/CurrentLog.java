package com.demo.dubbo.spi.log.impl;

import com.demo.dubbo.spi.log.Log;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName LogImpl2.java
 * @Description Log实现类2
 * @createTime 2020年05月14日 22:01:00
 */
public class CurrentLog implements Log {

    @Override
    public void print() {
        System.out.println(CurrentLog.class.getSimpleName());
    }
}
