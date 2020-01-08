package com.demo.thread.stopthreads.rightway;

/**
 * 普通线程中断的方式
 */
public class NormalStopThreads implements Runnable{

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted()
                && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NormalStopThreads());
        thread.start();
        // 模拟中断前的耗时操作
        thread.sleep(1000);
        thread.interrupt();
    }
}
