package com.guo.roy.research.misc.pattern.factory.abstractFactory;

import com.guo.roy.research.misc.pattern.factory.CPU;
import com.guo.roy.research.misc.pattern.factory.GAMainBoard;
import com.guo.roy.research.misc.pattern.factory.IntelCpu;
import com.guo.roy.research.misc.pattern.factory.MainBoard;

/**
 * Created by apple on 2019/5/4.
 */
public class NewYorkFactory implements AbstractFactory {
    @Override
    public CPU makeCpu() {

        return new IntelCpu();
    }

    @Override
    public MainBoard makeMainBoard() {

        return new GAMainBoard();
    }
}
