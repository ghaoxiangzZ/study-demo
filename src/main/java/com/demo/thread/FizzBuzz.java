package com.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName Foo.java
 * @Description TODO
 * @createTime 2020年06月19日 18:20:00
 */
public class FizzBuzz {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (n % 3 == 0 && n % 5 != 0) {
                printFizz.run();
            }
        }
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (n % 5 == 0 && n % 3 != 0) {
                printBuzz.run();
            }
        }
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (n % 3 == 0 && n % 5 == 0) {
                printFizzBuzz.run();
            }
        }
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (n % 3 != 0 && n % 5 != 0) {
                printNumber.accept(n);

            }
        }
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
