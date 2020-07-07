package com.designpattern.decorator;

public class MilkDecorator extends AbstractDecorator{
	
	private static final int MILK_PRICE = 2;
	private static final String MILK_DES = " with Milk";
	
	public MilkDecorator(AbstractCoffee aCoffee) {
		super(aCoffee);
	}
	
	@Override
	public String getDes() {
		return super.getDes() + MILK_DES;
	}
	
	@Override
	public int getPrice() {
		return super.getPrice() + MILK_PRICE;
	}

}
