package com.roy.miscellaneous.mockchain;

public class Filter2 implements Filter {

    @Override
    public Integer doFilter(Invoker invoker, Integer data) {
        System.out.println("进入Filter2:" + data);
//        System.out.println("----Filter2入参:" + data);
        Integer result = invoker.invoke(invoker, data);
        result += 1;
//        System.out.println("----Filter2出参:" + result);
        System.out.println("离开Filter2:" + result);
        return result ;
    }
}
