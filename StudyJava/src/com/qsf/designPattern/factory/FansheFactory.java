package com.qsf.designPattern.factory;


/**
 * 简单工厂（反射）
 * <p>
 * 利用反射Class.forName(clz.getName()).newInstance()实现的简单工厂：
 * 特点：
 * 1、 它也是一个具体的类，非接口 抽象类。但它的create()方法，是利用反射机制生成对象返回，
 * 好处是增加一种产品时，不需要修改create()的代码。
 * 缺点：
 * 这种写法粗看牛逼，细想之下，不谈reflection的效率还有以下问题：
 * 1 、个人觉得不好，因为Class.forName(clz.getName()).newInstance()调用的是
 * 无参构造函数生成对象，它和new Object()是一样的性质，而工厂方法应该用于复杂对象的初始化 ，
 * 当需要调用有参的构造函数时便无能为力了，这样像为了工厂而工厂。
 * 2 、不同的产品需要不同额外参数的时候 不支持。
 */
public class FansheFactory {
    public static void main(String[] args) {
        /**
         * 另一种简单工厂
         * 利用Class.forName(clz.getName()).newInstance()
         */
        System.out.println("=====另一种简单工厂利用Class.forName(clz.getName()).newInstance()======" +
                "\n个人觉得不好，因为这样和简单的new一个对象一样，工厂方法应该用于复杂对象的初始化" +
                "\n 这样像为了工厂而工厂");
        //兰州拉面
        INoodles gh = StaticNoodlesFactory2.createNoodles(new GankouNoodles());
        gh.desc();
        //泡面
        INoodles pm = StaticNoodlesFactory2.createNoodles(new PaoNoodles());
        pm.desc();
        //泡面
        INoodles lz = StaticNoodlesFactory3.createNoodles(LzNoodles.class);
        lz.desc();
    }
}

class StaticNoodlesFactory2 {
    /**
     * 传入Class实例化面条产品类
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends INoodles> T createNoodles(INoodles iNoodles) {
        Class<T> clz = (Class<T>) iNoodles.getClass();
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

class StaticNoodlesFactory3 {
    /**
     * 传入Class实例化面条产品类
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends INoodles> T createNoodles(Class<T> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
