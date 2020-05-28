package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author guojun
 * @date 2020/5/27
 *
 * 874. 模拟行走机器人
机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

-2：向左转 90 度
-1：向右转 90 度
1 <= x <= 9：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物。

第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])

机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。



示例 1：

输入: commands = [4,-1,3], obstacles = []
输出: 25
解释: 机器人将会到达 (3, 4)
示例 2：

输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
输出: 65
解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处


提示：

0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
答案保证小于 2 ^ 31
 */
public class TestSolution874 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution874.class);


    static class Solution {


        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :
         29 ms
         , 在所有 Java 提交中击败了56.88%
         的用户
         内存消耗 :
         47.3 MB
         , 在所有 Java 提交中击败了100.00%
         的用户
         *
         * @param commands
         * @param obstacles
         * @return
         */
        public int robotSim(int[] commands, int[][] obstacles) {
            int direct = 0;//0上 1右 2下 3左

            Map<Integer, List<Integer>> obstaclesXMap =  new HashMap<>();
            Map<Integer, List<Integer>> obstaclesYMap =  new HashMap<>();
            buildObstaclesMap(obstacles, obstaclesXMap, obstaclesYMap);

            int maxDis =0;

            //step1 假设没有障碍物
            int x, y;
            x = y = 0;
            int dis = 0;

            for (int i = 0; i < commands.length; i++) {
                int command = commands[i];
                switch (command) {
                    case -1://右转
                        direct = (direct + 1) % 4;
                        break;
                    case -2://右转
                        direct = (direct +3) % 4 ;
                        break;
                    default://向前, 都是正数
                        switch (direct) {
                            case 0:
//                                y += command;
                                y = moveTONextPos(direct,  x, y ,x, y + command, obstaclesXMap, obstaclesYMap);
                                dis = x * x + y * y;
                                if ( dis > maxDis) {
                                    maxDis = dis;
                                }
                                break;
                            case 1:
//                                x += command;
                                x = moveTONextPos(direct,  x, y ,x+ command, y, obstaclesXMap, obstaclesYMap);
                                dis = x * x + y * y;
                                if ( dis > maxDis) {
                                    maxDis = dis;
                                }
                                break;
                            case 2:
//                                y -= command;
                                y = moveTONextPos(direct,  x, y ,x, y - command, obstaclesXMap, obstaclesYMap);
                                dis = x * x + y * y;
                                if ( dis > maxDis) {
                                    maxDis = dis;
                                }
                                break;
                            case 3:
//                                x -= command;
                                x = moveTONextPos(direct,  x, y ,x - command, y, obstaclesXMap, obstaclesYMap);
                                dis = x * x + y * y;
                                if ( dis > maxDis) {
                                    maxDis = dis;
                                }
                                break;
                        }
                        break;
                }
            }
            return maxDis;
        }

        private void buildObstaclesMap(int[][] obstacles, Map<Integer, List<Integer>> obstaclesXMap, Map<Integer, List<Integer>> obstaclesYMap) {
            if (obstacles.length == 0) {
                return;
            }

            for (int[] obstacle : obstacles) {
                int x = obstacle[0];
                int y = obstacle[1];

                obstaclesXMap.compute(x, (key, old) -> {
                    if (old == null) {
                        List<Integer> set = new ArrayList<>();
                        set.add(y);
                        return set;
                    } else {
                        old.add(y);
                        return old;
                    }
                });

                obstaclesYMap.compute(y, (key, old) -> {
                    if (old == null) {
                        List<Integer> set = new ArrayList<>();
                        set.add(x);
                        return set;
                    } else {
                        old.add(x);
                        return old;
                    }
                });
            }
        }

        private int moveTONextPos(int direct, int x, int y, int toPosX, int toPosY ,Map<Integer, List<Integer>> obstacleMapGroupbyX, Map<Integer, List<Integer>> obstacleMapGroupbyY) {
            //向上，第一个纵坐标  （y, toPosY]
            //向右，第一个横坐标  (x,toPosX]
            //向下，第一个纵坐标  [toPosY,y)
            //向左，第一个横坐标  [toPosX,x)

            List<Integer> xList ;

            switch (direct) {
                case 0:
                    xList = obstacleMapGroupbyX.get(x);
                    if (xList != null && !xList.isEmpty()) {
                        Collections.sort(xList, (o1, o2) -> o1.compareTo(o2));
                        for (int i = 0; i < xList.size(); i++) {
                            Integer iVal = xList.get(i);
                            if (iVal > y && iVal <= toPosY) {
                                return iVal - 1;
                            }
                        }
                    }
                    return toPosY;
                case 1:
                    xList = obstacleMapGroupbyY.get(y);
                    if (xList != null && !xList.isEmpty()) {
                        Collections.sort(xList, (o1, o2) ->  o1.compareTo(o2));
                        for (int i = 0; i < xList.size(); i++) {
                            Integer iVal = xList.get(i);
                            if (iVal > x && iVal <= toPosX) {
                                return iVal - 1;
                            }
                        }

                    }
                    return toPosX;
                case 2:
                    xList = obstacleMapGroupbyX.get(x);
                    if (xList != null && !xList.isEmpty()) {
                        Collections.sort(xList, (o1, o2) ->  o2.compareTo(o1));
                        for (int i = 0; i < xList.size(); i++) {
                            Integer iVal = xList.get(i);
                            if (iVal >= toPosY && iVal < y) {
                                return iVal + 1;
                            }
                        }
                    }
                    return toPosY;
                case 3:
                    xList = obstacleMapGroupbyY.get(y);
                    if (xList != null && !xList.isEmpty()) {
                        Collections.sort(xList, (o1, o2) -> o2.compareTo(o1));
                        for (int i = 0; i < xList.size(); i++) {
                            Integer iVal = xList.get(i);
                            if (iVal >= toPosX && iVal < x) {
                                return iVal + 1;
                            }
                        }
                    }
                    return toPosX;
            }
            return 0;

        }


        /**
         *
         * 0 <= commands.length <= 10000
         0 <= obstacles.length <= 10000
         -30000 <= obstacle[i][0] <= 30000
         -30000 <= obstacle[i][1] <= 30000

         *
         * @param commands
         * @param obstacles
         * @return
         */
        public int robotSim1(int[] commands, int[][] obstacles) {
            int direct = 0;//0上 1右 2下 3左

            //step1 绘制地图
            int[][] map = new int[30000][30000];//30000 * 30000 地图
            for (int[] ints : map) {
                Arrays.fill(ints, 0);
            }
            for (int i = 0; i < obstacles.length; i++) {
                int[] obstacle = obstacles[i];
                map[obstacle[0] + 15000][Math.abs(obstacle[1] - 15000)] = 1;
            }


            //step1 假设没有障碍物
            int x, y;
            x = y = 0;
            for (int i = 0; i < commands.length; i++) {
                int command = commands[i];
                switch (command) {
                    case -1://右转
                        direct = (direct + 1) % 4;
                        logger.info("向右转");
                        break;
                    case -2://左转
                        direct = (direct +3) % 4 ;
                        logger.info("向左转");
                        break;
                    default://向前, 都是正数
                        switch (direct) {
                            case 0: // ↑
//                                y += command;
                                y = moveTONextPos1(direct, x, y, command, map);
                                logger.info("↑  ( {} , {}  ), [{}]", x, y, command);
                                break;
                            case 1: // →
//                                x += command;
                                x = moveTONextPos1(direct, x, y, command, map);
                                logger.info("→  ( {} , {}  ), [{}]", x, y, command);
                                break;
                            case 2:// ↓
//                                y -= command;
                                y = moveTONextPos1(direct, x, y, command, map);
                                logger.info("↓  ( {} , {}  ), [{}]", x, y, command);
                                break;
                            case 3:// ←
//                                x -= command;
                                x = moveTONextPos1(direct, x, y, command, map);
                                logger.info("←  ( {} , {}  ), [{}]", x, y, command);
                                break;
                        }
                        break;
                }
            }
            return x * x + y * y;
        }

        /**
         *
         *
         *
         * @param direct
         * @param x
         * @param y
         * @param command
         * @param map
         * @return  没有障碍返回-1，  有障碍返回障碍的前一个坐标
         */
        private int moveTONextPos1(int direct, int x, int y, int command, int[][] map) {
            //超出障碍物map
            if (Math.abs(x)> 15000 || Math.abs(y)> 15000 ) {
                return  -1;
            }

            int target;
            switch (direct) {
                case 0:
                    target = y + command;
                    int i ;
                    for (i = y; i <= target; i++) {
                        if (map[x + 15000][Math.abs(i - 15000)] == 1) {
                            break;
                        }
                    }
                    if (i > target) {
                        return target;
                    } else {
                        logger.info("障碍物");
                        return  i -1;
                    }
                case 1:
                    target = x + command;
                    for (i = x; i <= target; i++) {
                        if (map[i + 15000][Math.abs(y - 15000)] == 1) {
                            break;
                        }
                    }
                    if (i > target) {
                        return target;
                    } else {
                        logger.info("障碍物");
                        return  i -1;
                    }
                case 2:
                    target = y - command;
                    for (i = y; i >= target; i--) {
                        if (map[x + 15000][Math.abs(i - 15000)] == 1) {
                            break;
                        }
                    }
                    if (i < target) {
                        return target;
                    } else {
                        logger.info("障碍物");
                        return  i +1 ;
                    }
                case 3:
                    target = x - command;
                    for (i = x; i >= target; i--) {
                        if (map[i + 15000][Math.abs(y - 15000)] == 1) {
                            break;
                        }
                    }
                    if (i < target) {
                        return target;
                    } else {
                        logger.info("障碍物");
                        return  i + 1;
                    }
            }
            return 0;

        }

    }

    public static void main(String[] args) {
        
        logger.info("{}", new Solution().robotSim(
                new int[]{1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,-2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7},
                new int[][]{{-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},
                        {24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22},{14,-25},{-11,69},{63,36},{35,-99},{-24,82},{-29,-98},{-50,-70},
                        {72,95},{80,80},{-68,-40},{65,70},{-92,78},{-45,-63},{1,34},{81,50},{14,91},{-77,-54},{13,-88},{24,37},{-12,59},{-48,-62},{57,-22},{-8,85},{48,71},{12,1},
                        {-20,36},{-32,-14},{39,46},{-41,75},{13,-23},{98,10},{-88,64},{50,37},{-95,-32},{46,-91},{10,79},{-11,43},{-94,98},{79,42},{51,71},{4,-30},{2,74},{4,10},
                        {61,98},{57,98},{46,43},{-16,72},{53,-69},{54,-96},{22,0},{-7,92},{-69,80},{68,-73},{-24,-92},{-21,82},{32,-1},{-6,16},{15,-29},{70,-66},{-85,80},{50,-3},
                        {6,13},{-30,-98},{-30,59},{-67,40},{17,72},{79,82},{89,-100},{2,79},{-95,-46},{17,68},{-46,81},{-5,-57},{7,58},{-42,68},{19,-95},{-17,-76},{81,-86},{79,78},
                        {-82,-67},{6,0},{35,-16},{98,83},{-81,100},{-11,46},{-21,-38},{-30,-41},{86,18},{-68,6},{80,75},{-96,-44},{-19,66},{21,84},{-56,-64},{39,-15},{0,45},{-81,-54},
                        {-66,-93},{-4,2},{-42,-67},{-15,-33},{1,-32},{-74,-24},{7,18},{-62,84},{19,61},{39,79},{60,-98},{-76,45},{58,-98},{33,26},{-74,-95},{22,30},{-68,-62},{-59,4},
                        {-62,35},{-78,80},{-82,54},{-42,81},{56,-15},{32,-19},{34,93},{57,-100},{-1,-87},{68,-26},{18,86},{-55,-19},{-68,-99},{-9,47},{24,94},{92,97},{5,67},{97,-71},
                        {63,-57},{-52,-14},{-86,-78},{-17,92},{-61,-83},{-84,-10},{20,13},{-68,-47},{7,28},{66,89},{-41,-17},{-14,-46},{-72,-91},{4,52},{-17,-59},{-85,-46},{-94,-23},
                        {-48,-3},{-64,-37},{2,26},{76,88},{-8,-46},{-19,-68}}));//5140

        /*logger.info("{}", new Solution().robotSim1(
                new int[]{7,-2,-2,7,5},
                new int[][]{{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}}));//4

        logger.info("{}", new Solution().robotSim1(
                new int[]{-2,-1,8,9,6},
                new int[][]{{-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}}));//0

        logger.info("{}", new Solution().robotSim1(
                new int[]{4,-1,4,-2,4},
                new int[][]{{2,4}}));//65
        logger.info("{}", new Solution().robotSim1(
                new int[]{4,-1,3},
                new int[][]{}));//25*/


    }
}
