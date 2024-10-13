package ThreadLocal;

import java.sql.SQLOutput;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zwy
 * @version 1.0
 * @description: ThreadLocal with ThreadPool 线程的复用会导致数据的泄露和错误
 * @date 2024/10/13 19:38
 */

class MyData{
    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(()->0);

    public void add(){
        threadLocalField.set(threadLocalField.get() + 1);
    }
}

public class ThreadLocalDemo2 {
    public static void main(String[] args) {

        MyData myData = new MyData();
        // 线程池模拟三个消费者
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                threadPool.submit(()->{
                    try{
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName() + "办理顾客" + finalI +
                                "before:" + beforeInt + "after:" + afterInt);
                    }finally {
                        //避免复用
                        myData.threadLocalField.remove();
                    }
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }
}
