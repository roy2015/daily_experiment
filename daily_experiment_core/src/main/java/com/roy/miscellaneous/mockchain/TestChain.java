package com.roy.miscellaneous.mockchain;

/**
 * 参考dubbo 的filterChain写一个chain
 * 这也是一个拦截器，都是一个原理
 *
 *
 * @param <T>
 */
public class TestChain<T extends Number> {

    public Invoker buildInvokerChain(Filter[] filters, final Invoker lastInvoke) {
        Invoker last = lastInvoke;
        for (int i = filters.length - 1; i >= 0; i--) {
            final Filter filter = filters[i];
            final Invoker next = last;
            last = new Invoker() {
                @Override
                public Integer invoke(Invoker invoker, Integer data) {
                    return filter.doFilter(next, data);
                }
            };
        }
        return last;
    }

    public void testChain(int origdata) {
        Filter[] filters = new Filter[]{
                new Filter1(),
                new Filter2(),
                new Filter3(),
                new Filter4()
        };

        //实际要执行的操作
        Invoker realInvoker = new Invoker() {
            @Override
            public Integer invoke(Invoker invoker, Integer data) {
                System.out.println(String.format("进入Excute..%s", data));
                return data + 100;
            }
        };
        Invoker invoker = buildInvokerChain(filters, realInvoker);
        invoker.invoke(invoker, origdata);
    }

    public static void main(String[] args) {
        new TestChain<>().testChain(3);
    }
}
