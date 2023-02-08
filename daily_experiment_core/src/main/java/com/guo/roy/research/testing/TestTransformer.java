package com.guo.roy.research.testing;

import org.apache.commons.collections4.functors.InvokerTransformer;

/**
 * Created by apple on 2019/10/4.
 */
public class TestTransformer {

    public static void main(String[] args) {
        String[] cmds = new String[]{"open", "/Applications/Calculator.app/"};
        InvokerTransformer invokerTransformer1 = new InvokerTransformer("exec", new Class[]{String[].class}, new Object[]{cmds});
        invokerTransformer1.transform(Runtime.getRuntime());
    }
}
