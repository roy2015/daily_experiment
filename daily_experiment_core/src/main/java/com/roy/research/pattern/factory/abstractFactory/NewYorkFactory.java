package com.roy.research.pattern.factory.abstractFactory;

import com.roy.research.pattern.factory.CPU;
import com.roy.research.pattern.factory.GAMainBoard;
import com.roy.research.pattern.factory.IntelCpu;
import com.roy.research.pattern.factory.MainBoard;

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
