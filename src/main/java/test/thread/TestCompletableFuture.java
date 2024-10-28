package test.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author xiongyong
 * @date 2022/10/27 20:21
 **/

public class TestCompletableFuture {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> ss = CompletableFuture.supplyAsync(() -> {
            System.out.println("ss");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1";
        }).thenApply(p -> {
            System.out.println(p);
            return "task2";
        }).thenApply(p -> {
            System.out.println(p);
            return p + "task3";
        });
        System.out.println(ss.join());

        System.out.println("====================================");
        CompletableFuture<String> test4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "test4";
        });

        CompletableFuture<String> test5 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "test5";
        });
/*
        CompletableFuture<String> stringCompletableFuture = test4.thenCombine(test5, (t1, t2) -> {
            System.out.println("结果归并");
            return t1 + t2;
        });

        System.out.println(stringCompletableFuture.join());*/


        // 串行并行操作不会返回结果，只决定执行方式
        System.out.println("================并行====================");
        // 串行
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(test4, test5);
        System.out.println(objectCompletableFuture.join());
        System.out.println(test4.join());
        System.out.println(test5.join());

        System.out.println("================串行====================");
        // 并行
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(test4, test5);
        voidCompletableFuture.join();
        System.out.println(test4.join());
        System.out.println(test5.join());

        System.out.println("==============end=============");

    }
}