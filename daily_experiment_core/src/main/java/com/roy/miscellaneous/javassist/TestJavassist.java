package com.roy.miscellaneous.javassist;

import javassist.*;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestJavassist {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestJavassist.class);



    public void testJavassist() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.makeClass("com.roy.miscellaneous.targetObject.SuperUserVO");

            ctClass.setSuperclass(classPool.get("com.roy.miscellaneous.javassist.UserVO"));
            ctClass.addField(CtField.make("private int age =100;", ctClass));
            ctClass.addMethod(CtMethod.make("public int invokeMethod() { return 2124; } ", ctClass));
            Class superUserCls = ctClass.toClass();
            UserVO userVO = (UserVO) superUserCls.newInstance();
            logger.info("{}",userVO.invokeMethod());


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


    }
}
