package com.qsf.java;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理类
 * 1、public long getTime(Date date)
 * 2、java提供了一个日期处理类SimpleDateFormat
 * @author XiaoQiu
 *
 */
public class DateUtilDemo {

	public static void main(String[] args) {
		Date date = new Date(System.currentTimeMillis());
		Date date2 = new Date();
		System.out.println(date);
		System.out.println(date2.getTime());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd ");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年mm月dd日");
		String str = sdf.format(date);
		String str2 = sdf2.format(date);
		System.out.println(str);
		System.out.println(str2);
		
	}
}
