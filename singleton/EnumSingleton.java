package com.designpattern.singleton;

/*
 * �������̰߳�ȫ��ʵ�ַ�ʽ
 * ö�������޷��÷����ȡ��������������ֹ���乥������ȫ�Ը�ǿ
 */
public enum EnumSingleton {
	INSTANCE;
	
	public EnumSingleton getInstance() {
		return INSTANCE;
	}
}
