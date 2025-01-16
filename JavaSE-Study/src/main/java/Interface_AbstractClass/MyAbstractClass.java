package Interface_AbstractClass;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/16 18:55
 */
public abstract class MyAbstractClass {

    protected int i = 0;

    private int j = 0;

    int m = 0;//子类可以访问同一包中的父类的默认成员变量
    abstract void hello();

    void helloWorld(){
        j++;
        System.out.println("hello world!");
    }
}
