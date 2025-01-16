package Interface_AbstractClass;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/16 19:01
 */
public class InterfaceInstance implements MyInterface{
    FriendlyClass fc = new FriendlyClass();
    @Override
    public void hello() {
        System.out.println("hello world" + MyInterface.i);
    }
}
