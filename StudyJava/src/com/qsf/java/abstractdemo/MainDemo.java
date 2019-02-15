package com.qsf.java.abstractdemo;

/**
 * 项目中使用率10%
 * 抽象类-用abstract关键词进行定义
 * 抽象类定义之后不能像普通类那样直接用关键字new进行对象实例化操作，仅可以申明；
 * 使用原则：
 * 	  1、抽象类一定要被子类所继承；
 * 	  2、抽象类的子类（不是抽象类）则必须覆写抽象类之中全部的抽象方法；
 * 问题：
 * 	  1、抽象类在定义的时候是否能使用final关键字？
 * 		 不能，final类不能有子类，而抽象方法必须要被子类继承。
 * 	  2、抽象类之中能否定义构造方法？
 * 		能，因为抽象类只是比普通类多了抽象方法而已。
 * 	  3、抽象类之中可以没有抽象方法，但是此时依然无法直接产生抽象类的实例化对象。
 * 		
 *    4、请问抽象类是否可以用static修饰？
 *    	* 如果在定义一个普通的外部类的话，那么无法使用static来定义抽象类
 *      * 如果在定义一个内部类的话，那么就可以使用static定义
 *    5、  
 * 抽象类应用：-模板设计模式
 * 	  1、抽象类一定不是一个具体的类，它只是一个半成品，而子类负责实现这些未完成的功能。  
 *    2、 根据模板来实现子类定义，在学习到servlet技术的时候会使用到模板设计。
 *    3、应用例子：AppDemo.java
 * @author XiaoQiu
 *
 */
public class MainDemo {

	public static void main(String[] args) {
		Action.sleep sleep = new P();
		sleep.print();
		Action action = Action.getInstance();
		action.action();
	}
}

abstract class Action {
	 public Action(){}
	 
	private String msg = "HELLO";
	
	abstract public void action();
	
	public void eat(){
		System.out.println("eat...");
	}
	abstract static class sleep{
		abstract public void print();
	}
	private static class ActionB extends Action {
		public void action(){
			System.out.println("acitonB...");
		}
	}
	public static Action getInstance(){
		return new ActionB();
	}

}
class B extends Action{
	public void action() {
	}
}
class P extends Action.sleep{
	public void print() {
		System.out.println("sleep...");
	}
}
