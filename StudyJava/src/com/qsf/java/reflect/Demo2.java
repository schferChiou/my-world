package com.qsf.java.reflect;


/**
 * 关键字new和放射都可以实例化对象，有什么区别？
 * 用工厂设计模式来分析问题
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		
		Fruit fruit = Factory.GetInstance("apple");
		fruit.eat();
		
		
		Fruit fruit2 = Factory2.GetInstance("com.qsf.java.reflect.Orange");
		fruit2.eat();
	}
}
interface Fruit{
	public void eat();
}
class apple implements Fruit{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eat apple...");
	}
}
class Orange implements Fruit{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eat orange...");
	}
}
/**
 * 1、new对象的话，每增加一个子类（水果），那么就需要修改工厂类，耦合性太高，
 * @author XiaoQiu
 *
 */
class Factory{
	public static Fruit GetInstance(String className){
		if("apple".equals(className)){
			return new apple();
		}
		if("orange".equals(className)){
			return new Orange();
		}
		return null;
	}
}
/**
 * 1、通过反射机制处理的话，每增加一个子类（水果），工厂类不做任何处理，降低耦合性
 * @author XiaoQiu
 *
 */
class Factory2{
	public static Fruit GetInstance(String className){
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return fruit;
	}
}