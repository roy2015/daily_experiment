package com.roy.research.pattern.factory.abstractFactory;

import com.roy.research.pattern.factory.AmdCpu;
import com.roy.research.pattern.factory.CPU;
import com.roy.research.pattern.factory.MSIMainBoard;
import com.roy.research.pattern.factory.MainBoard;

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
