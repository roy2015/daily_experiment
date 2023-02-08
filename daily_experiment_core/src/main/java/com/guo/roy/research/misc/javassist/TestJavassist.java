package com.guo.roy.research.misc.javassist;

import javassist.*;
import org.slf4j.LoggerFactory;

public class TestJavassist {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestJavassist.class);


    /**
     * 走父类
     */
    public void testJavassist() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.makeClass("com.roy.miscellaneous.targetObject.SuperUserVO");

            StringBuilder c1 = new StringBuilder("public int invokeMethod(int x, int y)");
            c1.append("{  int k; if ($1 >= 10) { k=10; } else { k=$1; } return k + y; }");

            ctClass.setSuperclass(classPool.get("com.roy.miscellaneous.javassist.UserVO"));
            ctClass.addField(CtField.make("private int age =100;", ctClass));
            ctClass.addMethod(CtMethod.make(c1.toString(), ctClass));
            Class superUserCls = ctClass.toClass();
            UserVO userVO = (UserVO) superUserCls.newInstance();
            logger.info("{}",userVO.invokeMethod(9, 9));


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 走接口
     */
    public void testJavassist1() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.makeClass("com.roy.miscellaneous.targetObject.Pig");

            StringBuilder c1 = new StringBuilder("public int run() {");
            c1.append(" return org.apache.commons.lang3.RandomUtils.nextInt(100, 300);; }");

            ctClass.setInterfaces(new CtClass[]{classPool.get("com.roy.miscellaneous.javassist.Animal")});
            ctClass.addMethod(CtMethod.make(c1.toString(), ctClass));
            Class toClass = ctClass.toClass();
            Animal animal = (Animal) toClass.newInstance();

            logger.info("{}",animal.run());


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        new TestJavassist().testJavassist1();
    }


}
