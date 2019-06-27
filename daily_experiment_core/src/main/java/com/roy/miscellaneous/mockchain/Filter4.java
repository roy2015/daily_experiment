package com.roy.miscellaneous.mockchain;

public class Filter4 implements Filter {

    @Override
    public Integer doFilter(Invoker invoker, Integer data) {
        System.out.println("进入Filter4:" + data);
//        System.out.println("----Filter4入参:" + data);
        Integer result = invoker.invoke(invoker, data);
        result += 1;
//        System.out.println("----Filter4出参:" + result);
        System.out.println("离开Filter4:" + result);
        return result ;
    }
}
