package com.demo.thread.objectclassmethod;

/**
 * 演示内容：
 * 1、一共3个线程
 * 2、线程1和线程2先后进入阻塞，线程3分别使用notify和notifyAll去唤醒线程，观察区别
 * 3、演示thread.start先后顺序并不是代码书写的先后顺序
 */
public class WaitAndNotifyAll implements Runnable {

    private static final Object object1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WaitAndNotifyAll());
        Thread thread2 = new Thread(new WaitAndNotifyAll());
        Thread thread3 = new Thread(() -> {
            synchronized (object1) {
                object1.notifyAll();
                System.out.println(Thread.currentThread().getName() + " notify all threads");
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();
    }

    @Override
    public void run() {
        synchronized (object1) {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            try {
                System.out.println(Thread.currentThread().getName() + " release the lock");
                object1.wait();
                System.out.println(Thread.currentThread().getName() + " be notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
