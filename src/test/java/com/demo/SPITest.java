package com.demo;

import com.demo.dubbo.spi.loader.SPILoader;
import com.demo.dubbo.spi.log.Log;
import org.junit.jupiter.api.Test;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName SPITest.java
 * @Description 自定义SPI测试
 * @createTime 2020年05月14日 22:22:00
 */
public class SPITest {

    @Test
    public void test() throws Exception {
        //获取默认实现类
        Log defaultLog = SPILoader.getExtensionLoader(Log.class).getDefaultExtension();
        defaultLog.print();

        //指定特定的实现类
        Log currentLog = SPILoader.getExtensionLoader(Log.class).getExtension("currLog");
        currentLog.print();

    }

}
