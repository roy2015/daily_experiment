package com.roy.miscellaneous.pattern.decorator;

/**
* @author leno 装饰角色
*/
public class MessageBoardDecorator implements MessageBoardHandler {
	 private MessageBoardHandler handler;
	 public MessageBoardDecorator(MessageBoardHandler handler) {
	     super();
	     this.handler = handler;
	   }
	 public String filter(String msg) {
		 return handler.filter(msg);
	   }
}