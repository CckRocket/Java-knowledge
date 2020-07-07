package com.designpattern.strategy;

public class StrategyTest {
	public static void main(String[] args) {
		/*
		 * 导航类：Navigator
		 * 有三种策略供client选择：走路、开车、骑车
		 * 从A到B走路
		 * 从B到C开车
		 * 从C到D骑车
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
