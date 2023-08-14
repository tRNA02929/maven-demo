package com.ksyun.train;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

class Subject {
    public void sayHello() {
        System.out.println("HELLO WORLD");
    }
}
public class TestCglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Subject.class);
        enhancer.setCallback(
                (MethodInterceptor) (obj, method, argss, proxy) -> {
                    System.out.println("jdk proxy 调用方法前");
                    Object result = proxy.invokeSuper(obj, argss);
                    System.out.println("jdk proxy 调用方法后");
                    return result;
                }
        );
        Subject cglibProxy = (Subject) enhancer.create();
        cglibProxy.sayHello();
    }
}
