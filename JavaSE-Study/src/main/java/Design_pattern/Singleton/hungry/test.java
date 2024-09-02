package Design_pattern.Singleton.hungry;

import java.lang.reflect.Constructor;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/9/2 16:33
 */
public class test {
    public static void main(String[] args) throws Exception {
        // 反射破坏单例
        Constructor<Singleton> declaredConstructor =
                Singleton.class.getDeclaredConstructor(null);
        // 设置强制访问
        declaredConstructor.setAccessible(true);
        // 创建实例
        Singleton singleton =
                declaredConstructor.newInstance();

        System.out.println("反射创建的实例" + singleton);
        System.out.println("正常创建的实例" + Singleton.getInstance());
        System.out.println("正常创建的实例" + Singleton.getInstance());
    }
}
