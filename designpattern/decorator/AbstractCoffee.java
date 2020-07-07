package com.designpattern.decorator;

public abstract class AbstractCoffee {
	//抽象出要装饰的类型
	private String des;
	private int price;
	
	public String getDes() {
		return des;
	}
	
	public void setDes(String des) {
		this.des = des;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
