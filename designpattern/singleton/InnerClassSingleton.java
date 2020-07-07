package com.designpattern.singleton;


/*
 * �̰߳�ȫ����Ч�Ҽ���ʵ��
 * �Ƽ�ʹ��
 */
public class InnerClassSingleton {
	/*
	 * ���ھ�̬�ڲ���ᵥ������Ϊһ����ͨ�����ļ�
	 * ��̬�ڲ���ļ���Ҳ����ͨ��һ�������õ�ʱ�Ż����
	 * ��ˣ��ⲿ�����ʱ����̬�ڲ��಻�ᱻ����
	 * ����һ���߳�ִ��getInstance����ʱ���ڲ���ᱻ���أ�ʵ���ᱻ����
	 * ���������ֻ�����߳�ִ�У���Ȼ���̰߳�ȫ
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
