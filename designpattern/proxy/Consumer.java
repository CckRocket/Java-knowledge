package com.designpattern.proxy;

public class Consumer implements IConsumer{

	@Override
	public void buy() {
		System.out.println("buy things...");
	}

}
