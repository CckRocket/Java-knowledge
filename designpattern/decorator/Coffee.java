package com.designpattern.decorator;

public class Coffee extends AbstractCoffee {
	//最普通的没有装饰器的类 Coffee
	private static final String SIMPLE_COFFEE_DES = "Simple Coffee";
	private static final int PRICE = 10;
	
	public Coffee() {
		setDes(SIMPLE_COFFEE_DES);
		setPrice(PRICE);
	}
}
