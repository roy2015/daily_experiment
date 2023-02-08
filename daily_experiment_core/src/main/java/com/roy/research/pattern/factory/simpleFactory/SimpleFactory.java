package com.roy.research.pattern.factory.simpleFactory;

import com.roy.research.pattern.factory.*;

/**
 * Created by apple on 2019/5/4.
 *
 * 简单工厂
 */
public class SimpleFactory {


    public CPU makeCpu(CpuType cpuType) {
        switch (cpuType) {
            case AMD:
                return new AmdCpu();
            case INTEL:
                return new IntelCpu();
            default:
                return null;
        }
    }

    public MainBoard makeMainBoard(MainBoardType mainBoardType) {
        switch (mainBoardType) {
            case GA:
                return new GAMainBoard();
            case MSI:
                return new MSIMainBoard();
            default:
                return null;
        }
    }
}
