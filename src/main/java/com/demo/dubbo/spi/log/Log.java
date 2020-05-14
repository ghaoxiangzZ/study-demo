package com.demo.dubbo.spi.log;

import com.demo.dubbo.spi.annotation.SPI;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName Log.java
 * @Description 定义Log接口
 * @createTime 2020年05月14日 22:00:00
 */
@SPI(value = "defaultLog")
public interface Log {

    void print();
}
