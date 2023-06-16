package com.guo.roy.research.misc.proxy.pluginproxy;

import java.util.List;
import java.util.Properties;

import org.slf4j.LoggerFactory;

import com.guo.roy.research.misc.proxy.Warship;
import com.guo.roy.research.misc.proxy.pluginproxy.frame.*;

/**
 * @author guojun
 * @date 2021/3/8 上午10:24
 */

@MyIntercepts(
        {
                @MySignature( type = Warship.class, method = "fire", args = {int.class} )
        }

)
public class WarFireMyInterceptor implements MyInterceptor {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WarFireMyInterceptor.class);
    private static String exportStr = "毁伤评估报告， [%s]开火, 使用炮弹数[%s], 击毁数目[%s], 明细：[%s]...........";
    private static String export1Str = "毁伤评估报告，[%s]开火, , 未达预期【%s】";

    private Integer exportFireTargetQty;

    public WarFireMyInterceptor(Integer exportFireTargetQty) {
        this.exportFireTargetQty = exportFireTargetQty;
    }

    @Override
    public Object intercept(MyInvocation myInvocation) throws Throwable {
        Warship target = (Warship) myInvocation.getTarget();
        String warshipName = target.getWarshipName();

        int bombQty = (int) myInvocation.getArgs()[0];
        List<String> actualQty = (List<String>) myInvocation.proceed();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : actualQty) {
            stringBuilder.append(s);
        }
        logger.info(String.format(exportStr, warshipName, bombQty, actualQty.size(), stringBuilder.toString()  ));

        if (actualQty.size() < exportFireTargetQty  ) {
            logger.info(String.format(export1Str, warshipName, exportFireTargetQty));
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
