package com.guo.roy.research.misc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * 测试method和Object关系，证明是分离的，Method可以由interface得来，调用时才和Object发生联系
 *
 * @author guojun
 * @date 2023/7/11 13:02
 */
@Slf4j
public class MethodObjectTest {


    public  void main()  {
        Method method = null;
        try {
            method = Target.class.getMethod("test", int.class);
            TargetImpl obj = new TargetImpl();
            method.invoke(obj,1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new MethodObjectTest().main();
    }
}
