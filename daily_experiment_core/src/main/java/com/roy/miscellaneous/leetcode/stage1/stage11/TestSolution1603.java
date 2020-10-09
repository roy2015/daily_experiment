package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/09
 *
 * 1603. 设计停车系统
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 *
 * 请你实现 ParkingSystem 类：
 *
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检车是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 *
 * 解释：
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
 * parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
 * parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
 * parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
 *
 *
 * 提示：
 *
 * 0 <= big, medium, small <= 1000
 * carType 取值为 1， 2 或 3
 * 最多会调用 addCar 函数 1000 次
 *
 *
 */
public class TestSolution1603 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1603.class);


    /**
     *
     *
     * 执行结果：通过
     * 显示详情
     * 执行用时：11 ms, 在所有 Java 提交中击败了73.05%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了44.53%的用户
     *
     *
     */
    static class ParkingSystem {
        private int bigAmount;
        private int mediumAmount;
        private int smallAmount;

        public ParkingSystem(int big, int medium, int small) {
            bigAmount = big;
            mediumAmount = medium;
            smallAmount = small;
        }

        public boolean addCar(int carType) {
            boolean retVal = false;
            switch (carType) {
                case 1:
                    if (bigAmount > 0) {
                        bigAmount --;
                        retVal = true;
                    }
                    break;
                case 2:
                    if (mediumAmount > 0) {
                        mediumAmount --;
                        retVal = true;
                    }
                    break;
                case 3:
                    if (smallAmount > 0) {
                        smallAmount --;
                        retVal = true;
                    }
                    break;
                default:
                    break;
            }
            return retVal;
        }
    }

    /**
     * Your ParkingSystem object will be instantiated and called as such:
     * ParkingSystem obj = new ParkingSystem(big, medium, small);
     * boolean param_1 = obj.addCar(carType);
     */

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        logger.info("{}", obj.addCar(1)); // true
        logger.info("{}", obj.addCar(2)); // true
        logger.info("{}", obj.addCar(3)); // false
        logger.info("{}", obj.addCar(1)); // false

    }
}
