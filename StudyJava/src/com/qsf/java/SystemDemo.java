package com.qsf.java;

/**
 * system类
 * final、finally、finalize的区别：
 * 1、final：可以定义不能被继承的父类，定义不能被覆盖的方法、常量。
 * 2、finally：关键字，异常处理的统一出口，不管是否有异常都执行。
 * 3、finalize:方法protected void finalize()，Object类的方法，当对象被清理前执行的收尾操作。
 * @author XiaoQiu
 * 
 */
public class SystemDemo {
	public static void main(String[] args) {

		//获取当前日期时间
		System.out.println(System.currentTimeMillis());
	}
}
