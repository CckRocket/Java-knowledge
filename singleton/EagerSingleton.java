package com.designpattern.singleton;

public class EagerSingleton {
	//饿汉式，静态常量实现
	//在类加载时就完成了实例的创建，无法延迟加载，行为非常着急，所以叫做饿汉式
	private static EagerSingleton es = new EagerSingleton();
	
	private EagerSingleton() {
	}
	
	public static EagerSingleton getInstance() {
		return es;
	}
}
