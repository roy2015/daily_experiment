package com.guo.roy.research.misc.pattern.decorator;

/**
* @author leno 具体装饰角色，增加过滤掉HTML标签的功能
*/
public class HtmlFilter extends MessageBoardDecorator {
    public HtmlFilter(MessageBoardHandler handler) {
        super(handler);
    }

    public String filter(String content) {
        String temp = super.filter(content);
        temp += "^^过滤掉HTML标签!^^";
        return temp;
    }
}