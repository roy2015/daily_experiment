package com.roy.miscellaneous.pattern.factory.abstractFactory;

import com.roy.miscellaneous.pattern.factory.CPU;
import com.roy.miscellaneous.pattern.factory.MainBoard;

/**
 * Created by apple on 2019/5/4.
 */
public interface AbstractFactory {
    CPU makeCpu();
    MainBoard makeMainBoard();
}
