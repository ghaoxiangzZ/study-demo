package com.demo.singleton;

/**
 * 懒汉式-效率高且线程安全（多线程环境下最佳实践）
 */
public class LazySingletonSafeAndHighEfficiency {

    // 加volatile保证实例化时不会指令重排序
    private static volatile LazySingletonSafeAndHighEfficiency INSTANCE;

    private LazySingletonSafeAndHighEfficiency() {

    }

    // double-check
    public static LazySingletonSafeAndHighEfficiency getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingletonSafeAndHighEfficiency.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingletonSafeAndHighEfficiency();
                }
            }
        }
        return INSTANCE;
    }
}
