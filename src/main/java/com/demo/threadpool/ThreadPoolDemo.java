package com.demo.threadpool;

import jodd.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolDemo {

    private static final ThreadPoolExecutor threadPool = null;

    public static void main(String[] args) throws InterruptedException {
        printStats(threadPool);
        Thread.sleep(1000);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactoryBuilder().setNameFormat("demo-%d").get(),
                new DemoRejectedExecutionHandler());
        IntStream.rangeClosed(0, 1000).forEach(i -> threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + i)));
        Thread.sleep(1000);
    }

    private static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("=========================");
            System.out.println("Pool Size:"+threadPool.getPoolSize());
            System.out.println("Active Threads:"+threadPool.getActiveCount());
            System.out.println("Number of Tasks Completed: "+threadPool.getCompletedTaskCount());
            System.out.println("Number of Tasks in Queue: "+threadPool.getQueue().size());
            System.out.println("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
