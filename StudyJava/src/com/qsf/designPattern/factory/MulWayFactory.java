package com.qsf.designPattern.factory;
/**
 * 多方法工厂（常用）
 *  1、使用方法二 三实现的工厂，都有一个缺点：不同的产品需要不同额外参数的时候 不支持。
	而且如果使用时传递的type、Class出错，将不能得到正确的对象，容错率不高。
	而多方法的工厂模式为不同产品，提供不同的生产方法，使用时 需要哪种产品就调用该种产品的方法，
	使用方便、容错率高。
	
	2、查看java源码：java.util.concurrent.Executors类便是一个生成Executor 的工厂 ，其采用的便是 多方法静态工厂模式
 */
public class MulWayFactory {

	public static void main(String[] args) {
		/**
         * 多方法静态工厂(模仿Executor类）
         */
        System.out.println("==============================模仿Executor类==============================" +
                "\n 这种我比较青睐，增加一个新面条，只要去增加一个static方法即可,也不修改原方法逻辑");
        INoodles lz2 = MulWayNoodlesFactory.createLz();
        lz2.desc();

        INoodles gk2 = MulWayNoodlesFactory.createGk();
        gk2.desc();
	}
}
class MulWayNoodlesFactory {

    /**
     * 模仿Executors 类
     * 生产泡面
     *
     * @return
     */
    public static INoodles createPm() {
        return new PaoNoodles();
    }

    /**
     * 模仿Executors 类
     * 生产兰州拉面
     *
     * @return
     */
    public static INoodles createLz() {
        return new LzNoodles();
    }

    /**
     * 模仿Executors 类
     * 生产干扣面
     *
     * @return
     */
    public static INoodles createGk() {
        return new GankouNoodles();
    }
}