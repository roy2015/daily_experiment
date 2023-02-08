package com.roy.research.proxy.plugin;

import com.roy.research.proxy.Warship;
import com.roy.research.proxy.plugin.frame.*;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author guojun
 * @date 2021/3/8 上午10:24
 */

@MyIntercepts(
        {
                @MySignature( type = Warship.class, method = "seaway", args = {int.class} )
        }

)
public class SeawayMyInterceptor implements MyInterceptor {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SeawayMyInterceptor.class);
    private static String normalStr = "[%s], 航速[%s],正常航速请保持...........";
    private static String alarmlStr = "[%s], 航速[%s], 超速了!!,限速[%s]";
    private static String alarml1Str = "[%s], 静止航线！";

    private Integer limitSpeed;

    public SeawayMyInterceptor(Integer limitSpeed) {
        this.limitSpeed = limitSpeed;
    }

    @Override
    public Object intercept(MyInvocation myInvocation) throws Throwable {
        Warship target = (Warship) myInvocation.getTarget();
        String warshipName = target.getWarshipName();
        Integer seaway = (Integer) myInvocation.getArgs()[0];

        if (limitSpeed.compareTo(seaway) < 0) {
            logger.info(String.format(alarmlStr, warshipName, seaway, limitSpeed));
            logger.info(String.format(alarml1Str, warshipName));
        } else {
            logger.info(String.format(normalStr, warshipName, seaway));
            myInvocation.proceed();
        }
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return MyPlugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
