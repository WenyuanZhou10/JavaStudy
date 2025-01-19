package Wait_NotifyDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/19 20:04
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue tq = new TaskQueue();
        List<Thread> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Thread t = new Thread(() -> {
                while(true){
                    try {
                        String s = tq.getTask();
                        System.out.println(Thread.currentThread() + "task: " + s);
                    } catch (Exception e) {
                        return;
                    }
                }
            });
            t.start();
            list.add(t);
        }
        Thread add = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                String s = "t-" + i;
                System.out.println("add task: "+s);
                tq.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        });
        add.start();
        add.join();// 让主线程等待add执行结束
        Thread.sleep(1000);// 让主线程等待get线程执行结束
        for(Thread t : list){
            t.interrupt();
        }
    }
}
