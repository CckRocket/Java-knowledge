package com.designpattern.singleton;

/*
 * 最简洁且线程安全的实现方式
 * 枚举类型无法用反射获取构造器方法，防止反射攻击，安全性更强
 */
public enum EnumSingleton {
	INSTANCE;
	
	public EnumSingleton getInstance() {
		return INSTANCE;
	}
}
