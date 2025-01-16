package Interface_AbstractClass;

import Interface_AbstractClass.newPack.FatherClass;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/16 19:02
 */
public class test {



    public static void main(String[] args) {
        FriendlyClass fc = new FriendlyClass();// 可以访问同一个包的默认类
        FatherClass fatherClass = new FatherClass();
        SonClass sonClass = new SonClass();
        MyInterface.show();
        MyInterface mi = new InterfaceInstance();
        mi.defaultMethod();
        mi.hello();
        System.out.println("--------------");
        MyAbstractClass mac = new MyClass();
        mac.hello();
        mac.helloWorld();
        System.out.println("--------------");
        System.out.println(sonClass.n);

    }
}
