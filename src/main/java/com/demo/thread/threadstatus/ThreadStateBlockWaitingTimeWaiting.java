package com.demo.thread.threadstatus;

/**
 * 线程6个状态demo
 * new
 * runnable:Java没有running状态，正在运行和准备运行的线程，状态都是runnable
 * block
 * waiting
 * timed_wating
 * terminated
 */
public class ThreadStateBlockWaitingTimeWaiting implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadStateBlockWaitingTimeWaiting());
        Thread thread2 = new Thread(new ThreadStateBlockWaitingTimeWaiting());
        thread1.start();
        thread2.start();
        // 一个线程持久monitor，状态为blocked；另一个线程等待持有锁，timed_wating状态
        System.out.println("线程1的状态：" + thread1.getState());
        System.out.println("线程2的状态：" + thread2.getState());
        // 1000ms后，持有锁的线程丢弃锁，进入wait状态，第二个线程也进入wait状态
        Thread.sleep(1001);
        System.out.println("线程1的状态：" + thread1.getState());
        System.out.println("线程2的状态：" + thread2.getState());
    }

    private synchronized void syn() throws InterruptedException {
        Thread.sleep(1000);
        wait();
    }

    @Override
    public void run() {
        try {
            this.syn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
