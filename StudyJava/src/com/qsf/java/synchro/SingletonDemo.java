package com.qsf.java.synchro;
/**
 * jdk中用到的单例模式
 * --Runtime
 */

/**
 * 懒汉模式：
 * 1、构造器私有化，避免外部直接创建对象；
 * 2、声明一个私有的静态变量；
 * 3、创建一个对外的公共的静态方法，访问该变量，如果变量没有对象，则创建对象；
 * @author XiaoQiu
 *
 */
public class SingletonDemo {
	private static volatile SingletonDemo instance = null;
	private SingletonDemo() {

	}
	private static SingletonDemo getInstance(){
		//doubleChecking --提高效率
		if(null == instance){
			//同步锁，线程安全，
			synchronized (SingletonDemo.class) {//如何锁定静态方法
				if(null == instance){
					instance = new SingletonDemo();
				}
			}
		}
		return instance;
	}
}
/**
 * 饿汉模式：
 * 1、构造器私有化，避免外部直接创建对象；
 * 2、声明一个私有的静态变量，同时创建该对象；
 * 3、对外提供访问属性的静态方法；
 * @author XiaoQiu
 *
 */
class SingletonDemo2 {
	private static SingletonDemo2 instance = new SingletonDemo2();
	private SingletonDemo2() {
	}
	private static SingletonDemo2 getInstance(){
		return instance;
	}
}
/**
 * 类在使用的时候加载，延缓加载时间；
 * 
 * @author XiaoQiu
 *
 */
class SingletonDemo3 {
	private static class Jvm{
		private static SingletonDemo3 instance = new SingletonDemo3();
	}
	private SingletonDemo3() {
	}
	private static SingletonDemo3 getInstance(){
		return Jvm.instance;
	}
}