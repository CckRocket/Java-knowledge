package com.designpattern.singleton;

public class LazySingleton {
	/*
	 * volatile 关键字的作用
	 * 1.防止指令重排序
	 * 		ls = new LazySingleton() 的执行可分为以下三步：
	 * 			step.1  给对象分配内存
	 * 			step.2  调用构造器方法，执行对象的初始化
	 * 			step.3  将对象引用赋值给 ls 变量
	 * 		但由于Java编译器的优化，step.2 和 step.3 可能会互换位置
	 * 		这在多线程可能会导致以下问题：
	 * 			线程A执行了1和3，然后被OS挂起，释放了锁
	 * 			线程B进入临界区，这是检查到 ls 为 null，于是执行new LazySingleton()
	 * 			此时，线程A被唤醒，继续执行step.2，导致两个线程都创建了一个实例
	 * 2.内存可见
	 * 		保证线程A创建实例后，对之后的线程可见
	 */
	private static volatile LazySingleton ls;
	
	/*
	 * 构造器一定是私有的
	 * 否则，可从外部直接创建新实例
	 */
	private LazySingleton() {
		//do something
	}
	/*
	 * 双重校验，目的：提高并发度和效率
	 * 在单例模式中，创建实例的代码仅执行一次
	 * 加锁过程只需要在创建实例时进行
	 * 一旦实例创建完成，后续的获取实例操作就不再需要锁
	 */
	public static LazySingleton getInstance() {
		if(ls == null) {
			synchronized (LazySingleton.class) {
				if(ls == null) ls = new LazySingleton();
			}
		}
		return ls;
	}
	
	/* 非线程安全的写法
	 * 会出现两个线程同时判断 ls == null 为真的情况，因而会创建两个实例
	 * public LazySingleton getInstace() {
	 * 		if(ls == null) {
	 *			ls = new LazySingleton();
	 *		}
	 *		return ls;
	   }
	 */
	
}
