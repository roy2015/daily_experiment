package com.roy.miscellaneous.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * jdk动态代理
 *
 * @author: BG244210
 * Date:    22/10/2018
 * Description:
 */
public class JdkDynamicProxyTest implements InvocationHandler{

    private Target target;

    public JdkDynamicProxyTest(Target target) {
        this.target = target;
    }

    public static Target newProxyInstance(Target target) {
        return (Target) Proxy.newProxyInstance(JdkDynamicProxyTest.class.getClassLoader(), new Class[]{Target.class}, new JdkDynamicProxyTest(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }

    public static void main(String[] args) throws InterruptedException {
        Target target = JdkDynamicProxyTest.newProxyInstance(new TargetImpl());
        target.test(1);
        TimeUnit.MINUTES.sleep(10);
    }
}