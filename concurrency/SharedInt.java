package com.data.concurr;

public class SharedInt {
	private int val = 0;
	public synchronized void increase() {
		while(val != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ", val = " + val);
		
		val++;
		
		this.notifyAll();
	}
	public synchronized void decrease() {
		while(val != 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ", val = " + val);
		
		val--;
		
		this.notifyAll();
	}
	
}
