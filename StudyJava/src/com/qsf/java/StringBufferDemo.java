package com.qsf.java;
/**
 * String类的特点：
 * 1、一个字符串常量就是String类的匿名对象
 * 2、String类对象有两种实例化方式：
 * 		- 直接赋值，可以自动入池，只开辟一块内存空间
 * 		- 构造方法实例化，会开辟两块空间，其中一块将成为垃圾，不会自动入池，可以使用intern方法手工入池
 * 3、字符串内容一旦申明将不可改变。
 * 		
 * 因此在频繁修改字符串内容的程序上是不能够使用String的，StringBuffer和String的最大特征在于：
 * String内容不可改变，StingBuffer可以改变。
 * 		
 * @author XiaoQiu
 *
 */
public class StringBufferDemo {

}
