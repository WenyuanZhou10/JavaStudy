package Design_pattern.Singleton.lazy;

/**
 * @author zwy
 * @version 1.0
 * @description: 双重检查锁（DCL， 即 double-checked locking）
 * @date 2024/9/2 16:40
 */
public class test_safe {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(SafeSingleton.getInstance());
            }).start();
        }
    }
}
