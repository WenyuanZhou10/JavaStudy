package Reflect.demo;

import Reflect.pojo.TargetObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 1. 输入全类名获取
        Class<?> targetClass = Class.forName("Reflect.pojo.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();
        // 获取类中定义的所有方法
        Method[] methods = targetClass.getDeclaredMethods();
        Arrays.stream(methods).map(Method::getName).forEach(System.out::println);

        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "Hello World");

        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "Hello Field");
        System.out.println(field.get(targetObject));

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);


    }
}
