package com.qsf.java.interfacedemo;

public class Demo1 {

	public static void main(String[] args) {
		Computer computer =  new Computer();
		computer.plugin(new Flash());//向上转型，则执行被覆写的方法
		computer.plugin(new Print());
	}
}

interface USB{
	public void work();
	public void exit();
}
class Computer{
	public void plugin(USB usb){
		usb.work();
		usb.exit();
	}
}
class Flash implements USB{
	public void work() {
		System.out.println("U盘结束");
	}
	public void exit() {
		System.out.println("U盘结束");		
	}
}
class Print implements USB{
	public void work() {
		System.out.println("打印机工作");
	}
	public void exit() {
		System.out.println("打印机结束");
	}
}