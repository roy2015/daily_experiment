package com.roy.research.mockchain;

public class Filter3 implements Filter {

    @Override
    public Integer doFilter(Invoker invoker, Integer data) {
        System.out.println("进入Filter3:" + data);
//        System.out.println("----Filter3入参:" + data);
        Integer result = invoker.invoke(invoker, data);
        result += 1;
//        System.out.println("----Filter3出参:" + result);
        System.out.println("离开Filter3:" + result);
        return result ;
    }
}
