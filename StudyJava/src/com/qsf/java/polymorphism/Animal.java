package com.qsf.java.polymorphism;

public class Animal {

	private String nood;
	public void voice(){
		System.out.println("animal...");
	}
	
}

class Cat extends Animal{
	public void voice(){
		System.out.println("cat...");
	}
}
class Dog extends Animal{
	public void voice(){
		System.out.println("dog...");
	}
}

class Pig extends Animal{
	public void voice(){
		System.out.println("pig...");
	}
}