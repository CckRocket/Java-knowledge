package com.data.concurr;

public class IncreaseThread implements Runnable{
	private SharedInt sharedInt;
	public IncreaseThread(SharedInt sharedInt) {
		this.sharedInt = sharedInt;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sharedInt.increase();
		}
	}
}
