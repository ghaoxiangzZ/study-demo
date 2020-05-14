package com.demo.dubbo.spi.annotation;

import java.lang.annotation.*;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName spi.java
 * @Description SPI注解
 * @createTime 2020年05月14日 22:03:00
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {

    /**
     * 默认扩展点
     */
    String value() default "";
}
