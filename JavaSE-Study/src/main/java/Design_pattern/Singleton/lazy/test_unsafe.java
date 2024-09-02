package Design_pattern.Singleton.lazy;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/9/2 16:38
 */
public class test_unsafe {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            new Thread(()->{
                System.out.println("多线程创建的单例："+Singleton.getInstance());
            }).start();
        }
    }
}
