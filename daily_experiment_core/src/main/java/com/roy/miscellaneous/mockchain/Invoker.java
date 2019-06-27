package com.roy.miscellaneous.mockchain;

import org.omg.PortableInterceptor.INACTIVE;

public interface Invoker {
    Integer invoke(Invoker invoker, Integer data);
}
