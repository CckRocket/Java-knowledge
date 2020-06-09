package com.data.concurr;

public class DemoThread extends Thread{
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Demo Thread print " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
