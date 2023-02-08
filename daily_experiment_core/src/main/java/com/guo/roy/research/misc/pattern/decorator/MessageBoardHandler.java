package com.guo.roy.research.misc.pattern.decorator;

/**
* @author leno 用户留言板处理的接口
*/
public interface MessageBoardHandler {
	/**
	* @author leno 用户可以利用函数留言
	*/
	public String filter(String msg);
}