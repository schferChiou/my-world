package com.qsf.java.thread;
/**
 * 同步的经典案例
 * 生产者和消费者
 * @author XiaoQiu
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		Message msg = new Message();
		new Thread(new Productor(msg)).start();
		new Thread(new Customer(msg)).start();
	}
}
class Message {
	private String title;
	private String name;
	private boolean flag =false;
	public synchronized void set(String title,String name){
		if(this.flag == true){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.title = title;
		this.name = name;
		this.flag =true;
		super.notify();
	}
	public synchronized void get(){
		if(this.flag == false){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("title="+this.title+"---"+"name="+this.name);
		this.flag =false;
		super.notify();
	}
}
class Productor implements Runnable{

	private Message msg;
	public Productor(Message msg){
		this.msg =msg;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (i%2 ==0) {
				this.msg.set("我", "我");
			}else{
				this.msg.set("你", "你");
			}
		}
	}
}
class Customer implements Runnable{
	
	private Message msg;
	public Customer(Message msg){
		this.msg =msg;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
				this.msg.get();
		}
	}
}