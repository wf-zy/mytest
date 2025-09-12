package test.jdk21;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestVirtualThread {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("===========================================");
        CountDownLatch countDownLatch = new CountDownLatch(100000);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("task-1");
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 100000; i++) {
            executorService.submit(() -> {
                processTask("1");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        stopWatch.stop();
        stopWatch.start("task-2");
        System.out.println("==================22=========================");

        CountDownLatch countDownLatch2 = new CountDownLatch(100000);

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100000; i++) {
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

    }


    private static void processTask(String  name) {
        // 模拟轻量级计算或异步操作
        System.out.println(name+ ":"+Thread.currentThread());
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50));

    }
}
