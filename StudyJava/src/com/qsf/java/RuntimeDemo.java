package com.qsf.java;
/**
 * Runtime类
 * @author XiaoQiu
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println(	run.maxMemory());
		System.out.println(run.totalMemory());
		System.out.println(run.freeMemory());
		String str = "";
		for (int i = 0; i < 10000; i++) {
			str += i;
		}
		System.out.println("--------");
		System.out.println(	run.maxMemory());
		System.out.println(run.totalMemory());
		System.out.println(run.freeMemory());
		run.gc();
		System.out.println("--------");
		System.out.println(	run.maxMemory());
		System.out.println(run.totalMemory());
		System.out.println(run.freeMemory());
	}
}
