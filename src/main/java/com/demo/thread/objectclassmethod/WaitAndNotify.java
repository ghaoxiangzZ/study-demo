package com.demo.thread.objectclassmethod;

/**
 * 演示wait和notify的基本操作
 * 演示wait后会释放monitor
 */
public class WaitAndNotify {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "被唤醒，再次持有锁");
            }
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "执行唤醒操作");
            }
        }
    }
}
