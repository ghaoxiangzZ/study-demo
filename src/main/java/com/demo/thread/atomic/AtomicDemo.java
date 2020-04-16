package com.demo.thread.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName AtomicDemo.java
 * @Description
 * 1、原子类更新解决库存更新以及校验库存上限必须大于下限
 * 2、虽然upper、lower是原子类，但是当涉及到多个操作（例如比较upper和lower大小）就不是原子操作，还是得加同步锁
 * @createTime 2020年04月16日 23:08:00
 */
public class AtomicDemo {

    // 库存上限
    private final AtomicLong upper = new AtomicLong(0);
    // 库存下限
    private final AtomicLong lower = new AtomicLong(0);

    // 设置库存上限
    void setUpper(long v) {
        synchronized (this) {
            // 检查参数合法性
            if (v < lower.get()) {
                throw new IllegalArgumentException();
            }
            upper.set(v);
        }
    }

    // 设置库存下限
    void setLower(long v) {
        synchronized (this) {
            // 检查参数合法性
            if (v > upper.get()) {
                throw new IllegalArgumentException();
            }
            lower.set(v);
        }
    }
}
