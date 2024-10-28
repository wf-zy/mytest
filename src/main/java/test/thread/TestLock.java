package test.thread;

import com.google.common.collect.Lists;
import org.springframework.aop.ThrowsAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xiongyong
 * @Date 2022/1/25
 */

public class TestLock {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

      Thread thread1 =  new Thread(() -> {
          System.out.println("thread1");

            lock.lock();
            try {
                System.out.println("thread1 start=======");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("thread1 err");
            } finally {
                lock.unlock();
            }

            System.out.println("thread1 end=======");


        });

        Thread thread2 =  new Thread(() -> {
            System.out.println("thread2");
            System.out.println(lock.tryLock());
            try {
                System.out.println("thread2 start=======");

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("thread2 err");
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println("thread2 unlock=======");

                }
            }

            System.out.println("thread2 end=======");
        });

        thread1.start();
        thread2.start();

        System.out.println("==============end==============");
    }
}
