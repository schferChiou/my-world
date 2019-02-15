package com.qsf.java;

import java.math.BigDecimal;

public class BigDecimalDemo {

	public static void main(String[] args) {
		BigDecimal bDecimal = new BigDecimal("0.00");
		BigDecimal bDecimal2 = new BigDecimal("1111111.2042");
		bDecimal= bDecimal.add(bDecimal2);
		System.out.println(bDecimal.doubleValue()+"");
		System.out.println(bDecimal.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue()+""+"");
	}
}
