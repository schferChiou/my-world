package com.qsf.java.reflect;

import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.INEG;

/**
 * 反射
 * 1、实例化class类：在Object类之中定义的getClass()方法，发现里面返回的类型是Class,
 * 	    而Class是作为一切反射操作的源头表示。所以首先要清楚如何实例化class类对象，实际上有三种实例化方式
 * 	* 方式一:利用Object类的getClass()方法；
 *  * 方式二：通过"类.class" 取得；
 *  * 方式三：class类内部提供了一个static方法：forName()
 *	最没用处的就是第一种方式了，而第二种方式是在日后学习Hibernate的时候，现阶段主要使用第三种方式 ，
 *	第三种方式是spring的实现基础
 *
 *2、关键字new和放射都可以实例化对象，
 *
 *
 *3、使用反射操作类的结构
 *	类的基本结构就三部分：构造方法、普通方法、属性，而这些操作有了反射，一切都可以轻松面对
 * （1）调用构造
 * 		--  构造方法是在实例化的时候默认调用的，一个类之中可以提供有多个构造方法。
 * 		          在class类之中定义了如下取得构造方法的操作：
 * 			取得全部构造方法：getConstructors()
 * 			取得指定参数构造：Constructor()
 *
 */
public class Demo {
	public static void main(String[] args) {

		// 1、
		Date date = new Date();
		Class<?> cls = date.getClass();
		System.out.println(cls);
		// 2、
		Class<?> cls2 = Date.class;
		System.out.println(cls2);
		// 3、
		Class<?> cls3;
		try {
			cls3 = Class.forName("java.util.Date");

			System.out.println(cls3);
			try {
				// 创建对象
				System.out.println(cls3.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name =name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}