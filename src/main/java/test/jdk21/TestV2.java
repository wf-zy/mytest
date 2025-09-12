package test.jdk21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class TestV2 {
    public static void main(String[] args) {
        // 创建大量虚拟线程
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<CompletableFuture<String>> futures = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    // 模拟工作
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    if (taskId == 5) {
                        throw new RuntimeException("Task " + taskId + " failed");
                    }
                    return "Task " + taskId + " completed";
                }, executor);
                /*.thenApply(result -> {
                    System.out.println("Result: " + result);
                    return result;
                });
*/
                futures.add(future);
            }

            // 等待所有任务完成，调用join 方法可以保证所有任务同事成功或者失败（原子性），否则成功多少任务就返回多少
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            futures.stream().forEach(future -> {
                try {
                    System.out.println(future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            System.out.println("All tasks completed");
        }
    }
}
