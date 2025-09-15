package test.jdk21;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestVirtualThread {

    public static void main(String[] args) throws InterruptedException {

        Integer time  =1000;
        System.out.println("===========================================");
        CountDownLatch countDownLatch = new CountDownLatch(time);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("task-1");
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < time; i++) {
            executorService.submit(() -> {
                processTask("1");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        stopWatch.stop();
        stopWatch.start("task-2");
        System.out.println("==================22=========================");

        CountDownLatch countDownLatch2 = new CountDownLatch(time);

        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < time; i++) {
            int finalI = i;
            executorService1.submit(() -> {
                processTask("2");
                countDownLatch2.countDown();
            });
        }

        countDownLatch2.await();
        stopWatch.stop();
        System.out.println("==================000000=========================");

        System.out.println( stopWatch.prettyPrint());

        executorService.shutdown();
        executorService1.shutdown();
    }


    private static void processTask(String  name) {
        // 模拟轻量级计算或异步操作
        System.out.println(name+ ":"+Thread.currentThread());
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50));

    }
}
