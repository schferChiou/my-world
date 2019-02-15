package com.qsf.java.polymorphism;
/**
 * 多态：要有继承、要有方法重写、父类引用需要调用子类方法
 * @author XiaoQiu
 *
 */
public class Test {

	public static  void testVoice(Animal c){
		c.voice();
	}
	public static void main(String[] args) {
		Animal c = new Cat();
		Animal a = new Dog();
		Animal b = new Pig();
		testVoice(c);
		testVoice(a);
		testVoice(b);
	}
}
