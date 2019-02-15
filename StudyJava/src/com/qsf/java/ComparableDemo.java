package com.qsf.java;

import java.util.Arrays;


/**
 * 比较器Comparable
 * 1、String中的compareTo方法比较一个字符串
 * java.lang 
	类 String
	java.lang.Object
	  java.lang.String
	所有已实现的接口：
	Serializable, CharSequence, Comparable<String>
 * @author XiaoQiu
 *
 */
public class ComparableDemo {
	public static void main(String[] args) {
		Student st[] =  new Student[]{new Student("s",13,"2018"),new Student("a",28,"2098"),new Student("d",15,"2056")};
		Arrays.sort(st);
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i]);
		}
	}
}
class Student implements Comparable<Student>{
	private String name;
	private int age;
	private String date;
	public Student(String name,int age,String date) {
		this.name =name;
		this.age =age;
		this.date =date;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
//		if (this.age>o.age) {
//			return 1;
//		}else if(this.age<o.age){
//			return -1;
//		}
//		return 0;
		//调用String类的compareTo方法
		return this.date.compareTo(o.date);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}