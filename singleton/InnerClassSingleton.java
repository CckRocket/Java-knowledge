package com.designpattern.singleton;


/*
 * 线程安全、高效且简洁的实现
 * 推荐使用
 */
public class InnerClassSingleton {
	/*
	 * 由于静态内部类会单独编译为一个普通的类文件
	 * 静态内部类的加载也和普通类一样，在用到时才会加载
	 * 因此，外部类加载时，静态内部类不会被加载
	 * 当第一个线程执行getInstance方法时，内部类会被加载，实例会被创建
	 * 由于类加载只允许单线程执行，天然的线程安全
	 */
	private static class Holder {
		private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
	}
	
	private InnerClassSingleton() {
	}
	
	public InnerClassSingleton getInstance(){
		return Holder.INSTANCE;
	}
}
