package com.roy.miscellaneous.guava.event;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author guojun
 * @date 2021/1/12 下午7:22
 */
@Data
@Accessors(chain = true)
public class CustomEvent {

    private int eventId;

}
