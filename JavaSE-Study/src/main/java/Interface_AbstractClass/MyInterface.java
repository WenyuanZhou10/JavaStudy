package Interface_AbstractClass;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/16 18:57
 */
interface MyInterface {

    int i = 0;//默认为public static final 不需要单独声明
    static void show(){
        System.out.println("static method!" + i);
    }

    default void defaultMethod(){
        System.out.println("default method!");
    }

    void hello();
}
