package ThreadLocal;



import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author zwy
 * @version 1.0
 * @description: ThreadLocalDemo
 * @date 2024/10/13 19:22
 */

class car{
    @Getter
    private int saleTotal;

    public synchronized void saleTotal(){
        saleTotal++;
    }

    //ThreadLocal
//    ThreadLocal<Integer> salePersonal = new ThreadLocal<>(){
//        @Override
//        protected Object initialValue() {
//            return 0;//初始化为0
//        }
//    };
    //初始化为0
    ThreadLocal<Integer> salePersonal = ThreadLocal.withInitial(()->0);
    public void SalePersonal(){
        salePersonal.set(salePersonal.get()+1);
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        car car = new car();
        for (int i = 1; i <=3; i++){
            new Thread(()->{
                try {
                    for (int j = 1; j <= new Random().nextInt(3) + 1; j++){
                        car.saleTotal();
                        car.SalePersonal();
                    }
                    System.out.println(Thread.currentThread().getName()+"销售"+car.salePersonal.get());
                }finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//保证主线程在子线程执行完后开始执行

        System.out.println(Thread.currentThread().getName()+"销售"+car.getSaleTotal());
    }
}
