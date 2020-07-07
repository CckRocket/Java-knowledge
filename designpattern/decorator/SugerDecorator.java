package com.designpattern.decorator;

public class SugerDecorator extends AbstractDecorator {

	private static int SUGER_PRICE = 1;
	private static String SUGER_DES = " with Suger";
	
	public SugerDecorator(AbstractCoffee aCoffee) {
		super(aCoffee);
	}
	
	@Override
	public String getDes() {
		return super.getDes() + SUGER_DES;
	}
	
	@Override
	public int getPrice() {
		return super.getPrice() + SUGER_PRICE;
	}

}
