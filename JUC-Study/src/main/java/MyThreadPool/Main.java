package MyThreadPool;

import java.sql.SQLOutput;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/2/17 13:15
 */
public class Main {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        for (int i = 0; i < 5; i++) {
            myThreadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println("主线程没有被阻塞");
    }
}
