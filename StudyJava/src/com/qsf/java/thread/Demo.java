package com.qsf.java.thread;

/**
 * 线程
 * 线程安全设置：添加同步锁synchrozied
 * 异步处理和同步处理的区别：是否有synchronized
 * 过多的同步可能导致死锁
 * 在开发过程中使用runnable，可以有效的避免单继承局限
 * @author XiaoQiu
 *
 */
public class Demo {

	public static void main(String[] args) {
		MyThread sellPicture = new MyThread();
		new Thread(sellPicture, "票贩A").start();
		new Thread(sellPicture, "票贩B").start();
		new Thread(sellPicture, "票贩C").start();
		new Thread(sellPicture, "票贩D").start();
	}
}

class MyThread implements Runnable {

	private int tikets = 8;

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized(this){
				
		
			if (this.tikets > 0) {

				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ "---tikets=" + this.tikets--);
			}
			}
		}
	}

}