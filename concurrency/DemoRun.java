package com.data.concurr;

public class DemoRun implements Runnable{
	private int val = 5;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " val: " + val--);
	}
}
