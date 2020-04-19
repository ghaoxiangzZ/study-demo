package com.demo.thread.semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName ObjectPool.java
 * @Description 用Semaphore实现一个对象池
 * @createTime 2020年04月19日 21:49:00
 */
public class ObjectPool<T, R> {

    final List<T> pool;
    final Semaphore sem;

    public ObjectPool(int semSize, T t) {
        pool = new Vector<T>();
        for (int i = 0; i < semSize; i++) {
            pool.add(t);
        }
        sem = new Semaphore(semSize);
    }

    R exec(Function<T, R> function) {
        T t = null;
        try {
            sem.acquire();
            t = pool.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.add(t);
            sem.release();
        }
        return function.apply(t);
    }

    public static void main(String[] args) {
        ObjectPool<Long, String> pool = new ObjectPool<>(10, 2L);
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}
