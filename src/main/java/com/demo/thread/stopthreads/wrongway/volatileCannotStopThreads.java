package com.demo.thread.stopthreads.wrongway;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 错误示范：陷入阻塞中，volatile修饰boolean无法起到停止线程的作用
 * 生产者&消费者模式，当消费者消费速度无法跟上生产者的生产速度导致阻塞队列满了的情况。此时生产者会暂停等待消费者消费
 * 在这个例子中，queue.put(num);一直阻塞，无法接受到canceled变为true的状态，main函数运行不会终止
 */
public class volatileCannotStopThreads {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(arrayBlockingQueue);
        Thread thread = new Thread(producer);
        thread.start();
        Thread.sleep(1000);
        Consumer consumer = new Consumer(arrayBlockingQueue);
        while (consumer.needMore()) {
            System.out.println(arrayBlockingQueue.take() + "被消费掉了");
            Thread.sleep(1000);
        }
        System.out.println("消费者不需要更多数据了");
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}

class Producer implements Runnable {
    volatile boolean canceled = false;
    BlockingQueue queue;

    Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    queue.put(num);
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止运行");
        }
    }
}

class Consumer {
    BlockingQueue queue;

    Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    boolean needMore() {
        if (Math.random() > 0.95) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

