package com.demo.singleton;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName Singleton.java
 * @Description double-check单例
 * @createTime 2020年06月22日 10:18:00
 */
public class Singleton {

    private static volatile Singleton instance = null;

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // new Singleton()过程分为三步：①JVM为Singleton分配内存 ②Singleton初始化 ③将Singleton内存地址赋值给instance
                    // volatile可以防止以上3个步骤发生指令重排序；如果发生了指令重排，可能会导致顺序变成:JVM分配内存地址->将未初始化的Singleton对象赋值给instance引用->Singleton初始化
                    // 如果此时访问Singleton中的元素会报null pointer exception
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
