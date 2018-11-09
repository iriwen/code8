package com.h3c.joda;

/**
 * Created by a0285 on 2018/11/9.
 */
class Cl {
    static {
        System.out.println("Class  Cl");
    }
}
//调用Classloader的loadclass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
public class LoaderTest2 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("com.h3c.joda.Cl");
        System.out.println(clazz);

        System.out.println("--------------------");
        Class<?> clazz2 = Class.forName("com.h3c.joda.Cl");
        System.out.println(clazz2);

    }
}
