package com.roy.miscellaneous.proxy;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.proxy.ProxyFactory;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import sun.reflect.generics.tree.VoidDescriptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *
 * @author: BG244210
 * Date:    22/10/2018
 * modify   15/01/2021
 * Description:
 */
public class JdkDynamicProxyTest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JdkDynamicProxyTest.class);

    public static Warship newProxyInstance(Warship target) {
        return (Warship) Proxy.newProxyInstance(JdkDynamicProxyTest.class.getClassLoader(), new Class[]{Warship.class}, new WarProxy(target));
    }

    /**
     * 生成接口 Warship的代理类
     * @return
     */
    public static <T extends WarProxy> Warship newProxyInstance(T handler) {
        return (Warship) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{Warship.class}, handler);
    }

    /**
     * 获取代理类中个属性
     * @param warship
     */
    public void test2(Warship warship) {
        WarProxy warProxy = (WarProxy)Proxy.getInvocationHandler(warship);
        try  {
            Field warship1 = warProxy.getClass().getDeclaredField("warship");
            warship1.setAccessible(true);
            Object o = warship1.get(warProxy);
            logger.info("{}", o);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void test1() {
        Warship warship = JdkDynamicProxyTest.newProxyInstance(new WarProxy(new AircraftCarrier("辽宁舰")));
        warship.fire(1);

        Warship warship1 = JdkDynamicProxyTest.newProxyInstance(new WarProxy(new Destroyer("055")));
        warship1.fire(2);
    }

    public void test3 () {
        SeawayAlarmer.SeawayAlarmerBuilder seaway = new SeawayAlarmer.SeawayAlarmerBuilder().methodName("seaway").limitSpeed(30);

        for (int i = 1; i < 20; i++) {
            Warship warship = JdkDynamicProxyTest.newProxyInstance(seaway.warship(new AircraftCarrier("辽宁舰-" + i) ).build());
            warship.seaway(20 + i);

            Warship warship1 = JdkDynamicProxyTest.newProxyInstance(seaway.warship(new Destroyer("055-" + i)).build());
            warship1.seaway(25 + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JdkDynamicProxyTest jdkDynamicProxyTest = new JdkDynamicProxyTest();
        jdkDynamicProxyTest.test3();
    }


    /**
     * 调用处理器
     */
    @Data
    static class WarProxy implements InvocationHandler {
        protected Warship warship;

        public WarProxy(Warship warship) {
            this.warship = warship;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(warship, args);
        }
    }

    @Data
    @Accessors(chain = true)
    static class SeawayAlarmer extends WarProxy {
        private String methodName;
        private int limitSpeed;

        public SeawayAlarmer() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals(methodName)) {
                int arg = (int) args[0];
                if (arg > limitSpeed) {
                    logger.warn(" [{}], 实时航速[{}], 限速[{}],请减速!!!!!!",  warship.getWarshipName() ,arg, limitSpeed);
                }
            }
            return method.invoke(warship, args);
        }

        /**
         * builder
         */
        public  static final class  SeawayAlarmerBuilder {
            private SeawayAlarmer seawayAlarmer;

            public  SeawayAlarmerBuilder() {
                this.seawayAlarmer = new SeawayAlarmer();
            }

            public SeawayAlarmerBuilder methodName (String methodName) {
                seawayAlarmer.setMethodName(methodName);
                return this;
            }

            public SeawayAlarmerBuilder limitSpeed(int limitSpeed) {
                seawayAlarmer.setLimitSpeed(limitSpeed);
                return this;
            }

            public SeawayAlarmerBuilder warship(Warship warship) {
                seawayAlarmer.setWarship(warship);
                return this;
            }

            public SeawayAlarmer build() {
                return seawayAlarmer;
            }


        }

    }
}