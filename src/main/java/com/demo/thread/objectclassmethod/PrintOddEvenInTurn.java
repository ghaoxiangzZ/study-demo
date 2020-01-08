package com.demo.thread.objectclassmethod;

/**
 * 用wait/notify交替打印0-100的数字
 */
public class PrintOddEvenInTurn implements Runnable {
    private static int num = 0;
    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            while (num <= 100) {
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                lock.notify();
                if (num <= 100) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread threadOdd = new Thread(new PrintOddEvenInTurn());
        Thread threadEven = new Thread(new PrintOddEvenInTurn());
        threadOdd.start();
        threadEven.start();
    }
}
