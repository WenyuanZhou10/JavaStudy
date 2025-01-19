package Wait_NotifyDemo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/19 19:43
 */
public class TaskQueue {
    Deque<String> q = new ArrayDeque<>();

    public synchronized void addTask(String s){
        this.q.add(s);
        this.notifyAll();//唤醒全部正在等待中的线程，然后从wait方法返回
    }

    public synchronized String getTask(){
        while(q.isEmpty()){// 等待其他线程放入任务再取出来
            try {
                this.wait(); // 释放当前对象锁，避免其他线程获取不到对象
                // wait返回后尝试重新获取对象锁
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread()+"interrupt");
                throw new RuntimeException();
            }
        }
        return q.poll();
    }
}
