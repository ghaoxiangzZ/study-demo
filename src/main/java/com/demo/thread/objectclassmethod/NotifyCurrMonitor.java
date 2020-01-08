package com.demo.thread.objectclassmethod;

/**
 * notify仅仅释放指定的锁
 */
public class NotifyCurrMonitor {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("thread1 get lock1");
                synchronized (lock2) {
                    System.out.println("thread1 get lock2");
                    try {
                        System.out.println("thread1 release lock2");
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (lock1) {
                        System.out.println("thread2 get lock1");
                        System.out.println("thread2 tries to get lock2");
                        synchronized (lock2) {
                            System.out.println("thread2 get lock2");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
