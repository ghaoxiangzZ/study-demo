package com.demo.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程volatile不适用的场景
 * print:
 * volatileA = 17973, atomicA = 20000
 * volatileA = 19982, atomicA = 20000
 * ....
 */
public class UselessVolatile implements Runnable {
    volatile int volatileA;
    AtomicInteger atomicA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        UselessVolatile uselessVolatile = new UselessVolatile();
        Thread thread1 = new Thread(uselessVolatile);
        Thread thread2 = new Thread(uselessVolatile);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("volatileA = " + uselessVolatile.volatileA + ", atomicA = " + uselessVolatile.atomicA);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            volatileA++;
            atomicA.incrementAndGet();
        }
    }
}
