package MyThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/2/17 13:15
 */
public class Main {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 4, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new DiscardRejectHandle());
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            myThreadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() +" "+ finalI);
            });
        }
        System.out.println("主线程没有被阻塞");
    }
}
