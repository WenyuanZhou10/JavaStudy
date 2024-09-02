package Design_pattern.Singleton.hungry;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/9/2 16:31
 */
public class Singleton {

    // 定义一个静态变量指向自己
    private static final Singleton instance = new Singleton();
    // 私有化构造方法
    private Singleton(){}
    // 对外公共方法用于获取
    public static Singleton getInstance(){
        return instance;
    }

}
