# daily_experiment
做实验的project，以后逐渐替换daily_test（daily_test已经比较臃肿了）

新增代码注意：
1. 测试用例写在 src/test/java/***/MainTest里
2. 测试对象写在 src/main/java/*** 里
3. 目前用的是testNG
4. 引入第三方包是注意不要级联引入一堆的包！

玩贪吃蛇游戏
cd /Users/apple/guojun/code/github/exercise/daily_experiment/daily_experiment_core
mvn exec:java -Dexec.mainClass="com.guo.roy.research.game.Main"