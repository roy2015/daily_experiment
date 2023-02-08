package com.roy.research.pattern.factory.abstractFactory;

import com.roy.research.pattern.factory.CPU;
import com.roy.research.pattern.factory.MainBoard;

/**
 * Created by apple on 2019/5/4.
 */
public interface AbstractFactory {
    CPU makeCpu();
    MainBoard makeMainBoard();
}
