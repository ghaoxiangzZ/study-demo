package com.demo.dubbo.spi.holder;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName SPIHolder.java
 * @Description 拓展点包装类
 * @createTime 2020年05月14日 22:08:00
 */
public class SPIHolder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
