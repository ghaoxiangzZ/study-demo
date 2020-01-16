package com.demo.singleton;

/**
 * 懒汉式-线程安全但效率低下
 */
public class LazySingletonSafeLowEfficiency {

    private static LazySingletonSafeLowEfficiency INSTANCE;

    private LazySingletonSafeLowEfficiency() {
    }

    // 方法上加synchronized效率过低
    private synchronized static LazySingletonSafeLowEfficiency getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingletonSafeLowEfficiency();
        }
        return INSTANCE;
    }
}
