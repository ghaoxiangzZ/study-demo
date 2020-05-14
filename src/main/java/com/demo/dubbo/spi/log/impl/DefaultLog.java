package com.demo.dubbo.spi.log.impl;

import com.demo.dubbo.spi.log.Log;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName LogImpl1.java
 * @Description Log实现类1
 * @createTime 2020年05月14日 22:01:00
 */
public class DefaultLog implements Log {

    @Override
    public void print() {
        System.out.println(DefaultLog.class.getSimpleName());
    }
}
