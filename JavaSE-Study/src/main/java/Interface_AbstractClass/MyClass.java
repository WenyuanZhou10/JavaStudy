package Interface_AbstractClass;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/16 18:56
 */
public class MyClass extends MyAbstractClass{

    @Override
    void hello() {
        i = i+1;
        m++;
        System.out.println("hello! + i:" + i
                );
        System.out.println(m);
    }
}
