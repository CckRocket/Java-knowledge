package com.designpattern.singleton;

public class EagerSingleton {
	//����ʽ����̬����ʵ��
	//�������ʱ�������ʵ���Ĵ������޷��ӳټ��أ���Ϊ�ǳ��ż������Խ�������ʽ
	private static EagerSingleton es = new EagerSingleton();
	
	private EagerSingleton() {
	}
	
	public static EagerSingleton getInstance() {
		return es;
	}
}
