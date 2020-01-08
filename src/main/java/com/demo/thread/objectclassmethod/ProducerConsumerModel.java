package com.demo.thread.objectclassmethod;

import java.util.LinkedList;

/**
 * wait/notify实现生产者/消费者模型
 */
public class ProducerConsumerModel {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue(new LinkedList());
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i <= 100; i++) {
                queue.push();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                queue.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Queue {
    private static final int MAX_SIZE = 10;
    private LinkedList list;

    public Queue(LinkedList list) {
        this.list = list;
    }

    public synchronized void push() throws InterruptedException {
        while (list.size() == MAX_SIZE) {
            System.out.println("队列以满，等待消费商品");
            wait();
        }
        list.push(Math.random());
        System.out.println("生产商品:" + list.getFirst() + "，队列容量" + list.size());
        notify();
    }

    public synchronized void take() throws InterruptedException {
        while (list.size() == 0) {
            System.out.println("队列以空，等待生产商品");
            wait();
        }
        System.out.println("开始消费商品:" + list.poll() + ", 当前队列容量" + list.size());
        notify();
    }
}
