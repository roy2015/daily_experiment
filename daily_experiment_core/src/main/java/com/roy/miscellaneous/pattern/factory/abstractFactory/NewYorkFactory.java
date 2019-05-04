package com.roy.miscellaneous.pattern.factory.abstractFactory;

import com.roy.miscellaneous.pattern.factory.CPU;
import com.roy.miscellaneous.pattern.factory.GAMainBoard;
import com.roy.miscellaneous.pattern.factory.IntelCpu;
import com.roy.miscellaneous.pattern.factory.MainBoard;

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
