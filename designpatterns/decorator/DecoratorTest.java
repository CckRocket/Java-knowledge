package com.designpattern.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		AbstractCoffee coffee = new Coffee();
		
		AbstractDecorator milk1Coffee = new MilkDecorator(coffee);
		AbstractDecorator milk2Coffee = new MilkDecorator(milk1Coffee);
		AbstractDecorator orderCoffee = new SugerDecorator(milk2Coffee);
		System.out.println("Your Order: " + orderCoffee.getDes());
		System.out.println("Final Price: " + orderCoffee.getPrice());
	}

}
