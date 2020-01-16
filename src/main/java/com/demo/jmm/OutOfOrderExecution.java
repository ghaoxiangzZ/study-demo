package com.demo.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * java内存模型-指令重排序
 * 用CountDownLatch先将两个线程run方法阻塞，等全部线程start之后再放开，为了模拟两个线程交替执行的情形。
 * 将要执行的指令编号：
 * 1、a = 1;
 * 2、x = b;
 * 3、b = 1;
 * 4、y = a;
 * 可能的结果：
 * x = 1, y = 0 (jmm指令可能执行的顺序: 4->1->2->3、 1->4->2->3、 4->1->3->2、 1->4->3->2)
 * x = 0, y = 1 (jmm指令可能执行的顺序：2->3->1->4、 2->3->4->1、 3->2->1->4、 3->2->4->1)
 * x = 0, y = 0 (jmm指令可能执行的顺序: 2->4->1->3、 4->2->1->3、 2->4->3->1、 4->2->3->1)
 * x = 1, y = 1 (jmm指令可能执行的顺序：1->3->2->4、 1->3->4->2、 3->1->2->4、 3->1->4->4)
 */
public class OutOfOrderExecution {
    public static int x, y, a, b = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int i = 0;
        for (; ; ) {
            i++;
            x = y = a = b = 0;
            Thread thread1 = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
                y = a;
            });
            thread1.start();
            thread2.start();
            countDownLatch.countDown();
            thread1.join();
            thread2.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次执行：x = " + x + ", y = " + y);
                break;
            } else {
                System.out.println("第" + i + "次执行：x = " + x + ", y = " + y);
            }
        }
    }
}
