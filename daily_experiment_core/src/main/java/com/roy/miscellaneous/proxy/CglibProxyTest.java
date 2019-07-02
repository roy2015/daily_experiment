package com.roy.miscellaneous.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * cglib proxy
 *
 * @author: BG244210
 * Date:    22/10/2018
 * Description:
 */
public class CglibProxyTest implements MethodInterceptor {


    public static Target newProxyInstance(Class targetInstanceClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyTest());
        return (Target) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {
        Target cglibProxy = CglibProxyTest.newProxyInstance(TargetImpl.class);
        cglibProxy.test(3);
    }
}