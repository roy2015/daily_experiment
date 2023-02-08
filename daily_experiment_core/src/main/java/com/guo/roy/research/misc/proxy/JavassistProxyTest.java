package com.guo.roy.research.misc.proxy;

import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by apple on 2019/9/16.
 */
public class JavassistProxyTest implements MethodHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JavassistProxyTest.class);

    private Target target;

    public JavassistProxyTest() {
    }

    public JavassistProxyTest(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        logger.info("JavassistProxy invokde before;");
        Object invoke = thisMethod.invoke(target, args);
        logger.info("JavassistProxy invokde after;");
        return invoke;
    }

    /**
     * 走 proxyFactory（同jdk proxy) handler
     * @param target
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Target newProxyInstance (Target target) throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{Target.class});  //指定接口
        Class proxyClass = proxyFactory.createClass();
        Target javassistProxy = (Target) proxyClass.newInstance(); //设置Handler处理器
        ((ProxyObject) javassistProxy).setHandler(new JavassistProxyTest(target));
        return javassistProxy;
    }

    /**
     * 直接走代码生成
     * @param
     * @return
     */
    public Target newProxyInstanceNew() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("com.roy.miscellaneous.proxy.TargeExtension");
        ctClass.setSuperclass(classPool.get("com.roy.miscellaneous.proxy.TargetImpl"));
        StringBuilder sb = new StringBuilder();
        sb.append("public int test(int i) {\n" +
                "        System.out.println(i);\n" +
                "        return  i +1 ;\n" +
                "    }");
        CtMethod ctMethod = CtMethod.make(sb.toString(), ctClass);
        ctMethod.insertBefore("System.out.println(\"I can fly\");");
        ctMethod.insertAfter("System.out.println(\"I am falling\");");
        ctClass.addMethod(ctMethod);

        Class toClass = ctClass.toClass();
        return (Target) toClass.newInstance();
    }

    public static void main(String[] args) throws Exception {
        Target target = null;
        try {
//            target = new JavassistProxyTest().newProxyInstance(new TargetImpl());
            target = new JavassistProxyTest().newProxyInstanceNew();
            target.test(2);
//            TimeUnit.MINUTES.sleep(3);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
        }
    }


}
