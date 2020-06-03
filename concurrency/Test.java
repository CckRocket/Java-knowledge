package com.data.concurr;

public class Test {
	public static void main(String[] args) {
		SharedInt si = new SharedInt();
		IncreaseThread increaseThread1 = new IncreaseThread(si);
		IncreaseThread increaseThread2 = new IncreaseThread(si);
		DecreaseThread decreaseThread1 = new DecreaseThread(si);
		DecreaseThread decreaseThread2 = new DecreaseThread(si);
		new Thread(increaseThread1).start();
		new Thread(increaseThread2).start();
		new Thread(decreaseThread1).start();
		new Thread(decreaseThread2).start();
	}
}
