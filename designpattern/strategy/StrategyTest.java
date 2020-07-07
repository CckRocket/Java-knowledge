package com.designpattern.strategy;

public class StrategyTest {
	public static void main(String[] args) {
		/*
		 * �����ࣺNavigator
		 * �����ֲ��Թ�clientѡ����·���������ﳵ
		 * ��A��B��·
		 * ��B��C����
		 * ��C��D�ﳵ
		 */
		WalkStrategy walk = new WalkStrategy();
		DrivingStrategy driving = new DrivingStrategy();
		BikingStrategy bike = new BikingStrategy();
		
		Navigator navigator = new Navigator(walk);
		navigator.navigate("A", "B");
		
		navigator.setStrategy(driving);
		navigator.navigate("B", "C");
		
		navigator.setStrategy(bike);
		navigator.navigate("C", "D");
	}
}
