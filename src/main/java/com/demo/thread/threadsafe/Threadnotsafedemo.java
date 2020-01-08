package com.demo.thread.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class Threadnotsafedemo implements Runnable {

    private static AtomicInteger index = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Threadnotsafedemo());
        Thread thread2 = new Thread(new Threadnotsafedemo());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(index);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index.incrementAndGet();
        }
    }
}
