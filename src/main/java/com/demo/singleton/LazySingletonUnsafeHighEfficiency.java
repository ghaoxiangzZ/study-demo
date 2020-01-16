package com.demo.singleton;

/**
 * 懒汉式-效率稍高但是线程不安全
 */
public class LazySingletonUnsafeHighEfficiency {

    private static LazySingletonUnsafeHighEfficiency INSTANCE;

    private LazySingletonUnsafeHighEfficiency() {
    }

    // 用synchronized方法块效率比方法上加synchronized效率高，但是并不是线程安全的
    private static LazySingletonUnsafeHighEfficiency getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingletonUnsafeHighEfficiency.class) {
                INSTANCE = new LazySingletonUnsafeHighEfficiency();
            }
        }
        return INSTANCE;
    }
}
