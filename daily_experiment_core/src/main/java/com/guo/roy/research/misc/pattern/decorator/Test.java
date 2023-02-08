package com.guo.roy.research.misc.pattern.decorator;

/**
* @author leno 客户端测试
 *
 * 装饰模式（Decorator）也叫包装器模式（Wrapper）
 *
*/
public class Test {
//	 public static void main(String[] args) {
//	      MessageBoardHandler mb = new MessageBoard();
//	      String content = mb.filter("一定要学好装饰模式！");
//	      System.out.println(content);
//	   }
	   public static void main(String[] args) {
	      MessageBoardHandler mb = new MessageBoard();
	      String content = mb.filter("一定要学好装饰模式！");
	      System.out.println(content);
	      
	      mb = new HtmlFilter(new SensitiveFilter(new MessageBoard()));
	      content = mb.filter("一定要学好装饰模式！");
	      System.out.println(content);
		  }
}
