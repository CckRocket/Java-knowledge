package com.designpattern.decorator;

//extends AbstractCoffee 是装饰器正常工作的保证！
public abstract class AbstractDecorator extends AbstractCoffee{
	
	private AbstractCoffee aCoffee;
	
	public AbstractDecorator(AbstractCoffee aCoffee) {
		this.aCoffee = aCoffee;
	}
	
	public void setDes(String des) {
		this.aCoffee.setDes(des);
	}
	
	public void setPrice(int price) {
		this.aCoffee.setPrice(price);
	}
	
	public String getDes() {
		return this.aCoffee.getDes();
	}
	
	public int getPrice() {
		return this.aCoffee.getPrice();
	}
}
