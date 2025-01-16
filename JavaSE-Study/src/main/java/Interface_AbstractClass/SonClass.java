package Interface_AbstractClass;

import Interface_AbstractClass.newPack.FatherClass;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2025/1/16 19:44
 */
public class SonClass extends FatherClass {
    int n = m + 1; // 访问不到默认的非同一个包的父类成员变量
}
