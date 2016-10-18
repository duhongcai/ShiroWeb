package com.dhc.basicskill.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("basicskill.reflect.Car");
        Car car = (Car) clazz.newInstance();

        Method[] methods = clazz.getMethods();
        for (int i=0;i<methods.length;i++){
            System.out.println(methods[i].getName()+"---"+methods[i].getClass());
        }
        Method setBrand = clazz.getMethod("setBind",String.class);
        setBrand.invoke(car,"宝马");

        Field brand = clazz.getDeclaredField("bind");
        brand.setAccessible(true);
        brand.set(car,"迈巴赫");
        return car;
    }

    public static void main(String[] args) throws Throwable {
        System.out.println(initByDefaultConst().getBind());
    }
}
