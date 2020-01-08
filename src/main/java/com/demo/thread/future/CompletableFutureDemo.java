package com.demo.thread.future;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 参考文档：https://www.jianshu.com/p/6bac52527ca4、https://www.cnblogs.com/fingerboy/p/9948736.html
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {

        /**
         * thenRun(..)
         * runAsync-无返回值
         * 功能:对不关心上一步的计算结果，执行下一个操作
         * 场景:执行任务A,任务A执行完以后,执行任务B,任务B不接受任务A的返回值(不管A有没有返回值),也无返回值,接着继续执行任务
         */
        ExecutorService thenRunExecutor = Executors.newFixedThreadPool(3);
        JSONArray jsonArray = new JSONArray();
        Long start1 = System.currentTimeMillis();
        try {
            CompletableFuture.runAsync(() -> thenRunTask1(jsonArray), thenRunExecutor)
                    .thenRunAsync(() -> thenRunTask2(jsonArray), thenRunExecutor)
                    .thenRunAsync(() -> thenRunTask3(jsonArray), thenRunExecutor);
            Long end1 = System.currentTimeMillis();
            System.out.println("result:" + jsonArray.toJSONString() + ",timeMills:" + (end1 - start1) + "ms");
        } finally {
            thenRunExecutor.shutdown();
        }

        /**
         * thenAccept(..)
         * supplyAsync-有返回值
         * 功能:当前任务正常完成以后执行,当前任务的执行结果可以作为下一任务的输入参数,无返回值.
         * 场景:执行任务A,待任务A正常返回之后,用A的返回值执行任务B,任务B无返回值
         */
        ExecutorService thenAcceptExecutor = Executors.newFixedThreadPool(3);
        Long start2 = System.currentTimeMillis();
        try {
            CompletableFuture.supplyAsync(() -> thenAcceptTask1(), thenAcceptExecutor)
                    .thenAcceptAsync(s -> thenAcceptTask2(s.toString()), thenAcceptExecutor);
            Long end2 = System.currentTimeMillis();
            System.out.println("thenAccept cast timeMills:" + (end2 - start2) + "ms");
        } finally {
            thenAcceptExecutor.shutdown();
        }

        /**
         * thenApply(..)
         * 功能:当前任务正常完成以后执行，当前任务的执行的结果会作为下一任务的输入参数,有返回值
         * 场景:多个任务串联执行,下一个任务的执行依赖上一个任务的结果,每个任务都有输入和输出
         * 实例1:异步执行任务A,当任务A完成时使用A的返回结果resultA作为入参进行任务B的处理,可实现任意多个任务的串联执行
         */
        ExecutorService thenApplyExecutor = Executors.newFixedThreadPool(3);
        Long start3 = System.currentTimeMillis();
        try {
            String applyResult = CompletableFuture.supplyAsync(() -> thenApplyTask1(), thenApplyExecutor)
                    .thenApplyAsync(s1 -> thenApplyTask2(s1.toString()), thenApplyExecutor)
                    .thenApplyAsync(s2 -> thenApplyTask3(s2.toString()), thenApplyExecutor)
                    .join();
            Long end3 = System.currentTimeMillis();
            System.out.println("thenApply:" + applyResult + "cast timeMills:" + (end3 - start3) + "ms");
        } finally {
            thenApplyExecutor.shutdown();
        }

        /**
         * thenCombine(..)
         * 功能:结合两个CompletionStage的结果进行转化,有返回值
         */
        ExecutorService thenCombineExecutor = Executors.newFixedThreadPool(3);
        Long start4 = System.currentTimeMillis();
        try {
            String combineResult = CompletableFuture.supplyAsync(() -> thenCombileTask1(), thenCombineExecutor)
                    .thenCombineAsync(CompletableFuture.supplyAsync(() -> thenCombileTask2(), thenCombineExecutor), (s1, s2) -> s1 + "_" + s2)
                    .thenCombineAsync(CompletableFuture.supplyAsync(() -> thenCombileTask3(), thenCombineExecutor), (s1, s2) -> s1 + "_" + s2)
                    .join();
            Long end4 = System.currentTimeMillis();
            System.out.println("thenCombine:" + combineResult + "cast timeMills:" + (end4 - start4) + "ms");
        } finally {
            thenCombineExecutor.shutdown();
        }

        /**
         * exceptionally(..)
         * 功能：捕获异常
         */
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "futureA result true:" + s)
                .exceptionally(e -> "futureA expect 100 but error");
        CompletableFuture<String> futureB = CompletableFuture.
                supplyAsync(() -> "执行结果:" + 50)
                .thenApply(s -> "futureB result true:" + s)
                .exceptionally(e -> "futureB result expect 50 but error");
        System.out.println(futureA.join());
        System.out.println(futureB.join());
    }

    private static void thenRunTask1(JSONArray jsonArray) {
        System.out.println("thenRunTask1:" + Thread.currentThread().getName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "thenRunTask1");
        jsonArray.add(jsonObject);
    }

    private static void thenRunTask2(JSONArray jsonArray) {
        System.out.println("thenRunTask2:" + Thread.currentThread().getName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "thenRunTask2");
        jsonArray.add(jsonObject);
    }

    private static void thenRunTask3(JSONArray jsonArray) {
        System.out.println("thenRunTask3:" + Thread.currentThread().getName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "thenRunTask3");
        jsonArray.add(jsonObject);
    }

    private static String thenAcceptTask1() {
        System.out.println("thenAcceptTask1:" + Thread.currentThread().getName());
        return "thenAcceptTask1";
    }

    private static void thenAcceptTask2(String taskName) {
        System.out.println("thenAcceptTask2:" + Thread.currentThread().getName());
        System.out.println(taskName + "_thenAcceptTask2");
    }

    private static String thenApplyTask1() {
        System.out.println("thenAcceptTask1:" + Thread.currentThread().getName());
        return "thenAcceptTask1";
    }

    private static String thenApplyTask2(String taskName) {
        System.out.println("thenAcceptTask2:" + Thread.currentThread().getName());
        System.out.println(taskName + "_thenAcceptTask2");
        return taskName + "_thenAcceptTask2";
    }

    private static String thenApplyTask3(String taskName) {
        System.out.println("thenAcceptTask3:" + Thread.currentThread().getName());
        System.out.println(taskName + "_thenAcceptTask3");
        return taskName + "_thenAcceptTask3";
    }

    private static String thenCombileTask1() {
        System.out.println("thenCombileTask1:" + Thread.currentThread().getName());
        return "thenCombileTask1";
    }

    private static String thenCombileTask2() {
        System.out.println("thenCombileTask2:" + Thread.currentThread().getName());
        return "thenCombileTask2";
    }

    private static String thenCombileTask3() {
        System.out.println("thenCombileTask3:" + Thread.currentThread().getName());
        return "thenCombileTask3";
    }
}
