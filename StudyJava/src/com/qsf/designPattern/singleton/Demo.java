package com.qsf.designPattern.singleton;
/**
 * 单例设计模式：
 * 1、懒汉模式(饱汉模式)
 * 2、饿汉模式
 * 3、枚举模式
 * 4、占位符模式
 *
 * jdk用到的应用：runtime、NumberFormat
 * @author XiaoQiu
 *
 */
public class Demo {
	public static void main(String[] args) {

	}
}

/*
 * getInstance 添加了synchronized 关键字,也就是说 getInstance 是一个同步方法,
 * 这就是懒汉式在多线程中保持唯一性的方式
 *
 * 懒汉式存在的问题是,即是instance已经被创建,每次调用getInstance方法还是会同步,这样就会浪费一些不必要的资源
 * */
class LanHanPattern {
	private static LanHanPattern instance = null;

	private LanHanPattern() {

	}
	public static synchronized LanHanPattern getInstance() {
        if (instance == null) {
            instance = new LanHanPattern();
        }
        return instance;
    }
}
/**
 * getInstance 进行了两次判空,第一次判空是为了不必要的同步,第二次判空为了在instance 为 null 的情况下创建实例
 * 既保证了线程安全且单例对象初始化后调用getInstance又不会进行同步锁判断
 * <p>
 * 优点:资源利用率高,效率高
 * 缺点:第一次加载稍慢,由于java处理器允许乱序执行,偶尔会失败
 *
 * 使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性
 * 还没赋值完时，被另外线程调用
 * @return
 */
class  DoubleCheckLock {
	private static volatile DoubleCheckLock instance ;
	
	private DoubleCheckLock() {
		
	}
	
	public static DoubleCheckLock getInstance() {
		if (null == instance) {
			synchronized (LanHanPattern.class) {
				if (null == instance) {
					instance = new DoubleCheckLock();
				}
			}
		}
		return instance;
	}
}

/*
 * 饿汉式是在声明的时候就已经初始化Singleton1,确保了对象的唯一性
 *
 * 声明的时候就初始化对象会浪费不必要的资源
 *
 * 线性安全
 * */
class EHanPattern {
	private static EHanPattern instance = new EHanPattern();

	private EHanPattern() {
	}

	public static EHanPattern getInstance() {
		 return instance;
	}

}
/*
 *当第一次加载StaticPattern类时并不会初始化StaticPattern,只有第一次调用getInstance方法
 *的时候才会初始化StaticPattern
 *第一次调用getInstance 方法的时候虚拟机才会加载jvm类,
 *这种方式不仅能够保证线程安全,也能够保证对象的唯一,
 *还延迟了单例的实例化,所有推荐使用这种方式
 * */
class StaticPattern {
	
	private static class jvm {
		// 类在使用的时候加载，延缓加载时间；
		private static final StaticPattern instance = new StaticPattern();
	}
	
	private StaticPattern() {
	}
	
	public static StaticPattern getInstance() {
		// return instance;
		return jvm.instance;
	}
	
}
/**
 *枚举是写法最简单的
 * 默认枚举实例的创建时线程安全的,且在任何一种情况下它都是单例,包括反序列化
 * */
class EnumPattern {
	
	public enum SingletonEnum {
	    
	    INSTANCE;
	    private EnumPattern singleton;
	    //JVM会保证此方法绝对只调用一次
        private SingletonEnum(){
            singleton = new EnumPattern();
        }
        public EnumPattern getInstance(){
            return singleton;
        }
	}
	
	private EnumPattern() {
	}
	
	public static EnumPattern getInstance() {
		// return instance;
		return SingletonEnum.INSTANCE.getInstance();
	}
	
}
