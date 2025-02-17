package MyThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/2/17 13:14
 */
public class MyThreadPool {

    BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(1024);

    Thread thread = new Thread(()->{
        while(true){
            try {
                Runnable command = blockingDeque.take();//阻塞等待任务
                command.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    },"唯一线程");

    {
        thread.start();
    }

    // 1 线程什么时候创建
    // 2 线程runnable是什么
    void execute(Runnable command){
        boolean offer = blockingDeque.offer(command);
    }
}
