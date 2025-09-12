package test.queue;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1亿数据取前1000个
 * @Author xiongyong
 * @Date 2021/1/12
 */

public class TestQueue {

    public static void main(String[] args) {
        int i1 = Runtime.getRuntime().availableProcessors();
        // cpu 密集型,线程数量为核数加一
        ExecutorService executorService = Executors.newFixedThreadPool(i1+1);

        Integer a[] = new Integer[10000000];
        for (int i = 0; i < 10000000; i++) {
            a[i] =  i;
        }
        System.out.println("==============================================");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < 1000; i++) {
            priorityQueue.add(a[i]);
        }

        for (int i = 1000; i < a.length; i++) {
            Integer element = priorityQueue.element();

            if (element < a[i]) {
                priorityQueue.remove(element);
                priorityQueue.add(a[i]);
            }
        }

        List res = new ArrayList();
        for (Integer integer : priorityQueue) {

            res.add(integer);
        }
        Collections.sort(res);
        System.out.println(res);


        LinkedBlockingQueue queue =   new LinkedBlockingQueue();
        queue.offer(1);
        queue.poll();


    }
}
