package com.demo.thread.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName StampedLockDemo.java
 * @Description StampedLock读写demo：
 * 1、乐观读失败转换悲观锁
 * 2、写过程
 * @createTime 2020年04月19日 23:47:00
 */
public class Point {

    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    /*
     * @title move
     * @description write
     * @author haoxiang_guo
     * @param [deltaX, deltaY]
     * @updateTime 2020-04-19 23:54:54
     * @return void
     * @throws
     */
    public void move(double deltaX, double deltaY) {
        // 获取写锁
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 释放写锁
            stampedLock.unlockWrite(stamp);
        }
    }

    /*
     * @title distanceFromOrigin
     * @description read
     * @author haoxiang_guo
     * @param []
     * @updateTime 2020-04-19 23:55:03
     * @return double
     * @throws
     */
    public double distanceFromOrigin() {
        // 获得一个乐观读版本号
        long stamp = stampedLock.tryOptimisticRead();
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400),但此时版本号stamp已经改变，根据stampedLock.validate可以判断是否x、y被修改过

        // 检查乐观读后是否有其他写锁发生（注意，乐观读是无锁的，并不是乐观“锁”，无需加解锁操作）
        if (!stampedLock.validate(stamp)) {
            // 数据已被修改，获取一个悲观读锁
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                // 释放悲观读锁
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
