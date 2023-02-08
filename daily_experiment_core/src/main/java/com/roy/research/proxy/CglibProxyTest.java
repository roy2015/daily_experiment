package com.roy.research.proxy;

import org.slf4j.LoggerFactory;
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
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CglibProxyTest.class);

    private Target target;

    public CglibProxyTest(Target target) {
        this.target = target;
    }

    public static Target newProxyInstance(Class targetInstanceClazz, Target target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyTest(target));
        return (Target) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        logger.info("cglib proxy");
//        return  methodProxy.invoke(target, args);
        return methodProxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {
        Target cglibProxy = CglibProxyTest.newProxyInstance(TargetImpl.class, new TargetImpl());
        cglibProxy.test(3);
    }
}