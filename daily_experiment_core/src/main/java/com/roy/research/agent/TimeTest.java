package com.roy.research.agent;

/**
 * 被测试类
 *
 * java -javaagent:/Users/apple/guojun/code/github/my-agent/target/com.roy.agent-1.0-SNAPSHOT.jar=Hello1 -jar daily_experiment_core-1.0-SNAPSHOT-jar-with-dependencies.jar
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年3月30日
 */
public class TimeTest {

    public static void main(String[] args) {
        Helloword helloword = new Helloword();
        helloword.sayHello();
        helloword.sayHello2("hello world222222222");
    }


}