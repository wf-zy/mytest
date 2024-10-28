package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池某个线程报错对业务的影响
 * 
 * 如果某个线程报错，线程池内部已捕获异常，注意：系统不会报错但是报错线程后面的业务不会执行
 * 
 *  
 */
public class TestThreadPool3 {

	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.submit(() -> {

			System.out.println("线程1" + Thread.currentThread().getName());
			//throw new RuntimeException("手动抛出异常");d
			float a = 1/0;
			System.out.println(Thread.currentThread().getId());
			
		});

		executor.submit(() -> {
			System.out.println("线程2" + Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getId());
		});

		executor.submit(() -> {
			System.out.println("线程3" + Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getId());
		});
		executor.shutdown();
	}
}
