package com.roy.miscellaneous.proxy;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * jdk动态代理
 *
 * 演示了简单的动态代理，航母驱逐舰航速监控器，自定义InvocationHandler
 *
 * @author: BG244210
 * Date:    22/10/2018
 * modify   15/01/2021
 * Description:
 */
public class JdkDynamicProxyTest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JdkDynamicProxyTest.class);

    /**
     * 生成接口 Warship的代理类
     * @return
     */
    public static <T extends BaseInvocationHandler> Warship newProxyInstance(T handler) {
        return (Warship) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{Warship.class}, handler);
    }

    /**
     * 获取代理中invocationHandler里的属性
     */
    public void test2() {
        Warship warship = JdkDynamicProxyTest.newProxyInstance(new BaseInvocationHandler(new AircraftCarrier("辽宁舰")));
        //获取proxy所使用的InvocationHandler
        BaseInvocationHandler warProxy = (BaseInvocationHandler)Proxy.getInvocationHandler(warship);
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
        Warship warship = JdkDynamicProxyTest.newProxyInstance(new BaseInvocationHandler(new AircraftCarrier("辽宁舰")));
        logger.info("{}",AopUtils.isAopProxy(warship));

        warship.fire(1);

        Warship warship1 = JdkDynamicProxyTest.newProxyInstance(new BaseInvocationHandler(new Destroyer("055")));
        warship1.fire(2);
    }

    public void test3 () {
        SeawayAlarmer.SeawayAlarmerBuilder seawayBuilder1 = new SeawayAlarmer.SeawayAlarmerBuilder().methodName("seaway").limitSpeed(27);
        SeawayAlarmer.SeawayAlarmerBuilder seawayBuilder2 = new SeawayAlarmer.SeawayAlarmerBuilder().methodName("seaway").limitSpeed(27);
        Warship warship1 = JdkDynamicProxyTest.newProxyInstance(seawayBuilder1.warship(new AircraftCarrier("辽宁舰") ).build());
        Warship warship2 = JdkDynamicProxyTest.newProxyInstance(seawayBuilder2.warship(new Destroyer("055")).build());
        for (int i = 1; i < 10; i++) {
            warship1.seaway(20 + i);
            warship2.seaway(25 + i);
        }
        warship1.fire(1);
    }

    public static void main(String[] args) throws InterruptedException {
        JdkDynamicProxyTest jdkDynamicProxyTest = new JdkDynamicProxyTest();
        jdkDynamicProxyTest.test1();
        jdkDynamicProxyTest.test2();
    }


    /**
     *
     * 基本的 proxy wrapper
     */
    @Data
    static class BaseInvocationHandler implements InvocationHandler {
        protected Warship warship;

        public BaseInvocationHandler(Warship warship) {
            this.warship = warship;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(warship, args);
        }
    }

    /**
     * 航速监控器
     */
    @Data
    @Accessors(chain = true)
    static class SeawayAlarmer extends BaseInvocationHandler {
        //需要拦截的方法名
        private String methodName;
        private int limitSpeed;

        protected SeawayAlarmer() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals(methodName)) {
                int arg = (int) args[0];
                if (arg > limitSpeed) {
                    logger.warn(" [{}], 时间[{}] 实时航速[{}], 限速[{}],已超速，请减速！",  warship.getWarshipName() , DateUtil.formatDateTime(new Date()), arg, limitSpeed);
                } else {
                    logger.warn(" [{}], 时间[{}] 实时航速[{}], 正常航速，请保持",  warship.getWarshipName() , DateUtil.formatDateTime(new Date()), arg, limitSpeed);
                }
            } else {
                logger.info("执行了方法 {}", method.getName());
            }
            return method.invoke(warship, args);
        }

        /**
         * builder
         */
        static class  SeawayAlarmerBuilder {
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