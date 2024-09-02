package Design_pattern.Singleton.lazy;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/9/2 16:43
 */
public class SafeSingleton {
    private SafeSingleton(){}

    private static volatile SafeSingleton singleton;

    public static SafeSingleton getInstance(){
        if(singleton == null){
            synchronized (SafeSingleton.class){
                if(singleton == null)
                    singleton = new SafeSingleton();
            }
        }
        return singleton;
    }
}
