package com.demo.threadpool;

import lombok.SneakyThrows;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName DemoRejectedExecutionHandler.java
 * @Description 自定义拒绝策略
 * @createTime 2020年04月13日 22:07:00
 */
public class DemoRejectedExecutionHandler implements RejectedExecutionHandler {

    @SneakyThrows
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        executor.getQueue().offer(r, 10, TimeUnit.SECONDS);
        System.out.println("put to queue again");
    }
}
