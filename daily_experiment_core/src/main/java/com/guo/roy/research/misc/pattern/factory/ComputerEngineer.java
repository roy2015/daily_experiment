package com.guo.roy.research.misc.pattern.factory;

import com.guo.roy.research.misc.pattern.factory.abstractFactory.AbstractFactory;
import com.guo.roy.research.misc.pattern.factory.simpleFactory.SimpleFactory;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/5/4.
 *
 * 电脑装机工程师
 *
 */
public class ComputerEngineer {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ComputerEngineer.class);


    private CPU cpu;
    private MainBoard mainBoard;

    /**
     * 抽象工厂
     * @param abstractFactory
     */
    public void makeComputer(AbstractFactory abstractFactory) {
        cpu = abstractFactory.makeCpu();
        mainBoard =  abstractFactory.makeMainBoard();
        print();
    }

    /**
     * 简单工厂
     * @param simpleFactory
     * @param cpuType
     * @param mainBoardType
     */
    public void makeComputer(SimpleFactory simpleFactory, CpuType cpuType, MainBoardType mainBoardType) {
        cpu = simpleFactory.makeCpu(cpuType);
        mainBoard = simpleFactory.makeMainBoard(mainBoardType);
        print();
    }



    private void print() {
        cpu.calculate();
        mainBoard.installCpu();
    }
}
