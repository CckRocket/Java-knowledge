package com.data.concurr;

public class NonCASDemo {
	private int count = 0;
	
	public static void main(String[] args) {
		NonCASDemo demo = new NonCASDemo();
		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				for(int x = 0; x < 10000; x++) {
					demo.increase();
				}
			}).start();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(demo.getCount());
	}
	public int getCount() {
		return count;
	}
	public void increase() {
		count++;
	}
}
