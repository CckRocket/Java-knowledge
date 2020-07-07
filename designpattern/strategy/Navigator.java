package com.designpattern.strategy;

/*
 * �����ǣ���clientֱ�ӽ�������
 */
public class Navigator {
	
	private IStrategy iStrategy;
	
	public Navigator(IStrategy iStrategy) {
		this.iStrategy = iStrategy;
	}
	
	public void navigate(String locationA, String locationB) {
		this.iStrategy.planning(locationA, locationB);
	}
	
	public void setStrategy(IStrategy iStrategy) {
		this.iStrategy = iStrategy;
	}
}
