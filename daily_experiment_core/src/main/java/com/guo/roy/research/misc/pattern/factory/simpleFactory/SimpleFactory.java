package com.guo.roy.research.misc.pattern.factory.simpleFactory;

import com.guo.roy.research.misc.pattern.factory.*;

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
