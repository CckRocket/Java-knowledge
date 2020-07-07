package com.designpattern.proxy;

public class Proxy implements IConsumer{
	
	private Consumer consumer;
	
	public Proxy() {
		this.consumer = new Consumer();
	}
	
	@Override
	public void buy() {
		System.out.println("Proxy gets the task...");
		consumer.buy();
		System.out.println("Proxy completes the task...");
	}

}
