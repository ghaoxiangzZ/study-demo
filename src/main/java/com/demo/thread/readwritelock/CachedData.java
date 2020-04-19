package com.demo.thread.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName CachedData.java
 * @Description ReadWriteLock实践
 * @createTime 2020年04月19日 23:02:00
 */
public class CachedData {

    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    final Lock read = lock.readLock();
    final Lock write = lock.writeLock();

    void processCacheData() {
        read.lock();
        if (!cacheValid) {
            // 释放读锁,不允许直接从读锁升级为写锁
            read.unlock();
            // 获取写锁
            write.lock();
            try {
                if (!cacheValid) {
                    data = getDataFromDB();
                    cacheValid = true;
                }
                // 释放写锁前，降级为读锁
                read.lock();
            } finally {
                write.unlock();
            }
            // 此时还持有读锁
            try {
                useData();
            } finally {
                read.unlock();
            }
        }
    }

    Object getDataFromDB() {
        // 省略从DB查询操作
        return new Object();
    }

    void useData() {
        // 模拟对data进行的操作
    }
}
