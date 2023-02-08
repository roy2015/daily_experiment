package com.roy.research.mockchain;

public class Filter1 implements Filter {

    @Override
    public Integer doFilter(Invoker invoker, Integer data) {
        System.out.println("进入Filter1:" + data);
//        System.out.println("----Filter1入参:" + data);
        Integer result = invoker.invoke(invoker, data);
        result += 1;
//        System.out.println("----Filter1出参:" + result);
        System.out.println("离开Filter1:" + result);
        return result  ;
    }
}
