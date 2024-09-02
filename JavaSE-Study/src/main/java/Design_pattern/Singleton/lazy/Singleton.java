package Design_pattern.Singleton.lazy;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/9/2 16:37
 */
public class Singleton {
    private Singleton() {}

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
