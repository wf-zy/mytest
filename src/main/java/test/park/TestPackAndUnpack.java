package test.park;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.LockSupport;

/**
 * ????pack ??unpack
 * @author soonsmile
 *
 */
public class TestPackAndUnpack {

	public static void main(String[] args) {


        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

        concurrentSkipListMap.put(1,1);
        concurrentSkipListMap.put(2,16);
        concurrentSkipListMap.put(5,62);
        concurrentSkipListMap.put(8,42);
        concurrentSkipListMap.put(9,8);

        Map.Entry entry = concurrentSkipListMap.ceilingEntry(4);
        System.out.println(entry);
        Object o = concurrentSkipListMap.ceilingKey(4);
        System.out.println(o);

        Thread t = new Thread(() -> {
                System.out.println("子线程 park");
                LockSupport.park();
                System.out.println("子线程解除park");
            });
        t.start();

        new Thread(() -> {
            System.err.println("子线程2");
            try {
                Thread.sleep(5000);
                System.err.println("子线程2 休眠了5秒准备unpark");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t);
        }).start();


    }
}
