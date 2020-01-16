package com.demo.singleton;

/**
 * 饿汉式（静态常量）-可用
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    private static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
