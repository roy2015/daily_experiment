package com.guo.roy.research.misc.pattern.factory.abstractFactory;

import com.guo.roy.research.misc.pattern.factory.CPU;
import com.guo.roy.research.misc.pattern.factory.MainBoard;

/**
 * Created by apple on 2019/5/4.
 */
public interface AbstractFactory {
    CPU makeCpu();
    MainBoard makeMainBoard();
}
