package com.designpattern.singleton;

public class LazySingleton {
	/*
	 * volatile �ؼ��ֵ�����
	 * 1.��ָֹ��������
	 * 		ls = new LazySingleton() ��ִ�пɷ�Ϊ����������
	 * 			step.1  ����������ڴ�
	 * 			step.2  ���ù�����������ִ�ж���ĳ�ʼ��
	 * 			step.3  ���������ø�ֵ�� ls ����
	 * 		������Java���������Ż���step.2 �� step.3 ���ܻụ��λ��
	 * 		���ڶ��߳̿��ܻᵼ���������⣺
	 * 			�߳�Aִ����1��3��Ȼ��OS�����ͷ�����
	 * 			�߳�B�����ٽ��������Ǽ�鵽 ls Ϊ null������ִ��new LazySingleton()
	 * 			��ʱ���߳�A�����ѣ�����ִ��step.2�����������̶߳�������һ��ʵ��
	 * 2.�ڴ�ɼ�
	 * 		��֤�߳�A����ʵ���󣬶�֮����߳̿ɼ�
	 */
	private static volatile LazySingleton ls;
	
	/*
	 * ������һ����˽�е�
	 * ���򣬿ɴ��ⲿֱ�Ӵ�����ʵ��
	 */
	private LazySingleton() {
		//do something
	}
	/*
	 * ˫��У�飬Ŀ�ģ���߲����Ⱥ�Ч��
	 * �ڵ���ģʽ�У�����ʵ���Ĵ����ִ��һ��
	 * ��������ֻ��Ҫ�ڴ���ʵ��ʱ����
	 * һ��ʵ��������ɣ������Ļ�ȡʵ�������Ͳ�����Ҫ��
	 */
	public static LazySingleton getInstance() {
		if(ls == null) {
			synchronized (LazySingleton.class) {
				if(ls == null) ls = new LazySingleton();
			}
		}
		return ls;
	}
	
	/* ���̰߳�ȫ��д��
	 * ����������߳�ͬʱ�ж� ls == null Ϊ������������ᴴ������ʵ��
	 * public LazySingleton getInstace() {
	 * 		if(ls == null) {
	 *			ls = new LazySingleton();
	 *		}
	 *		return ls;
	   }
	 */
	
}
