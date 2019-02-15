package com.qsf.designPattern.factory;


/**
 * 普通工厂
 * 
 */
public class AbstractFactory {
	public static void main(String[] args) {
		/**
         * 普通工厂方法：
         */
        System.out.println("===========================普通工厂方法==============================" +
                "\n 这种要多写一个类，不过更面向对象吧 = = ，实际中我更倾向于使用【模仿Executor类】的方式");
        NoodlesFactory factory1 = new GankouFactory();
        INoodles gk3 = factory1.create();
        gk3.desc();
	}
}
abstract class NoodlesFactory {
    public abstract INoodles create();
}
class LzFactory  extends NoodlesFactory {//（具体工厂子类）：
	@Override
	public INoodles create() {
		return new LzNoodles();
	}
}

class PaoFactory  extends NoodlesFactory {//（具体工厂子类）：
	@Override
	public INoodles create() {
		return new PaoNoodles();
	}
}

class GankouFactory  extends NoodlesFactory {//（具体工厂子类）：
	@Override
	public INoodles create() {
		return new GankouNoodles();
	}
}