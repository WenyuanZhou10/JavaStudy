package MyThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/2/17 13:14
 */
public class MyThreadPool {

    private final int corePoolSize;
    private final int maxSize;
    private final int timeOut;
    private final TimeUnit timeUnit;
    public final BlockingQueue<Runnable> blockingQueue;
    private final RejectHandle rejectHandle;
    public MyThreadPool(int corePoolSize, int maxSize, int timeOut, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectHandle rejectHandle){
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.blockingQueue = blockingQueue;
        this.rejectHandle = rejectHandle;
    }
    List<Thread> coreList = new ArrayList<>();

    List<Thread> supportList = new ArrayList<>();

    void execute(Runnable command){
        // 小于核心线程数时，创建一个新的线程
        if(coreList.size() < corePoolSize){
            Thread thread = new CoreThread();
            coreList.add(thread);
            thread.start();
        }
        if(blockingQueue.offer(command)){
            return;
        }
        // 阻塞队列满了，将创建一个新的辅助线程
        if(coreList.size() + supportList.size() < maxSize){
            Thread thread = new supportThread();
            supportList.add(thread);
            thread.start();
        }
        if(!blockingQueue.offer(command)){
            rejectHandle.reject(command, this);
        }
    }

    class CoreThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable command = blockingQueue.take();//阻塞等待任务
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //辅助线程阻塞获取不到任务一段时间后自动结束
    class supportThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable command = blockingQueue.poll(timeOut, timeUnit);//阻塞等待任务
                    if(command == null){
                        break;
                    }
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束");
        }
    }
}
