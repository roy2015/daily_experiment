package com.guo.roy.research.misc.pattern.factory.abstractFactory;

import com.guo.roy.research.misc.pattern.factory.AmdCpu;
import com.guo.roy.research.misc.pattern.factory.CPU;
import com.guo.roy.research.misc.pattern.factory.MSIMainBoard;
import com.guo.roy.research.misc.pattern.factory.MainBoard;

/**
 * Created by apple on 2019/5/4.
 */
public class CaliforniaFactory implements AbstractFactory {
    @Override
    public CPU makeCpu() {
        return new AmdCpu();
    }

    @Override
    public MainBoard makeMainBoard() {
        return new MSIMainBoard();
    }
}
