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
public class ThreadStateNewRunableTerminated implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadStateNewRunableTerminated());
        System.out.println("实例化线程的状态：" + thread.getState());
        thread.start();
        System.out.println("线程启动之后的状态：" + thread.getState());
        Thread.sleep(5);
        System.out.println("线程正在执行计算的状态：" + thread.getState());
        Thread.sleep(100);
        System.out.println("线程执行完毕的状态：" + thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
