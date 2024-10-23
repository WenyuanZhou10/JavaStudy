package Synchronized;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                while(true){
                    try{
                        String s = q.getTask();
                        System.out.println("执行任务：" + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = "t-" + Math.random();
                System.out.println("add task:" + s);
                q.addTask(s);
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){

                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for(Thread t : ts){
            t.interrupt();
        }
    }
}
