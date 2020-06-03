package com.data.concurr;

public class DecreaseThread implements Runnable{
	private SharedInt sharedInt;
	public DecreaseThread(SharedInt sharedInt) {
		this.sharedInt = sharedInt;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sharedInt.decrease();
		}
	}
}
