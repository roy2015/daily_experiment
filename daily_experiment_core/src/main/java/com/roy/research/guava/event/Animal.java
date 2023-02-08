package com.roy.research.guava.event;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author guojun
 * @date 2021/1/13 下午3:52
 */
@Data
@Accessors(chain = true)
public class Animal {
    private String name;
    private int age;
}
