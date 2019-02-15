package com.qsf.java.abstractdemo;

public class AppDemo {
	public static void main(String[] args) {
		Person person = new Person();
		person.command(ActionApi.EAT);
	}
}

abstract class ActionApi{
	public static final int SLEEP = 1;
	public static final int EAT = 5;
	public static final int WORK = 10;
	public abstract void eat(); 
	public abstract void sleep(); 
	public abstract void work();
	public void command(int key){
		switch (key) {
		case SLEEP:
			sleep();
			break;
		case EAT:
			eat();
			break;
		case WORK:
			work();
			break;
		case SLEEP+EAT:
			sleep();
			eat();
			break;
		case SLEEP+WORK:
			sleep();
			work();
			break;
		case EAT+WORK:
			eat();
			work();
			break;
		default:
			System.out.println("未知错误");
			break;
		}
	}
}
 class Person extends ActionApi{

	 public void eat() {
		// TODO Auto-generated method stub
		System.out.println("人在吃饭");
	}
	 public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("人在睡觉");
	}

	 public void work() {
		// TODO Auto-generated method stub
		System.out.println("人在工作");
	}
	
}
class Pig extends ActionApi{

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("猪在进食");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("猪在睡觉");
	}

	public void work() {
		// TODO Auto-generated method stub
	}
}
class Robot extends ActionApi{

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("机器在充电中");
	}

	public void sleep() {
		// TODO Auto-generated method stub
	}

	public void work() {
		// TODO Auto-generated method stub
		System.out.println("机器在运行中");
	}
	
}