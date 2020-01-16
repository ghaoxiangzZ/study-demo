package com.demo.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo implements Runnable {

    private int id;
    private CountDownLatch latch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public ThreadPoolDemo(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("线程:" + Thread.currentThread().getName() + "执行ID:" + id);
        try {
            Thread.sleep(10);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        long start = System.currentTimeMillis();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
        for (int i = 0; i < 1000; i++) {
            ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo(i, countDownLatch);
            threadPoolExecutor.execute(threadPoolDemo);
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start) + "ms");
    }
}
