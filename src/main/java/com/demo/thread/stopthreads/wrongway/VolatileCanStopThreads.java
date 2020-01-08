package com.demo.thread.stopthreads.wrongway;

/**
 * v0latile修饰boolean来停止线程
 */
public class VolatileCanStopThreads implements Runnable {

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanStopThreads volatileCanStopThreads = new VolatileCanStopThreads();
        Thread thread = new Thread(volatileCanStopThreads);
        thread.start();
        Thread.sleep(5000);
        volatileCanStopThreads.canceled = true;


    }
}
