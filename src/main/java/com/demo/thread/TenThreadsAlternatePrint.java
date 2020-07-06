package com.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName TenThreadsAlternatePrint.java
 * @Description 十个线程交替打印
 * @createTime 2020年06月22日 10:37:00
 */
public class TenThreadsAlternatePrint {
    static volatile int a = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        new Thread(() -> {
            while (a <= 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + a++);
                    condition2.signal();
                    condition1.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }, "thread 1").start();

        new Thread(() -> {
            while (a <= 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + a++);
                    condition3.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }, "thread 2").start();

        new Thread(() -> {
            while (a <= 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + a++);
                    condition1.signal();
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }, "thread 3").start();
    }

}
