package com.demo.singleton;

/**
 * 懒汉式-线程不安全
 */
public class LazySingletonUnsafe {

    private static LazySingletonUnsafe INSTANCE;

    private LazySingletonUnsafe() {
    }

    private static LazySingletonUnsafe getInstance() {
        if (INSTANCE == null) {
            // 多线程环境下同时进入此分支，会创建多个实例
            INSTANCE = new LazySingletonUnsafe();
        }
        return INSTANCE;
    }
}
