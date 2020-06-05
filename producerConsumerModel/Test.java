package com.data.producerconsumer;

public class Test {
	public static void main(String[] args) {
		BoundedBuffer buffer = new BoundedBuffer();
		//lambda expression
		new Thread(() -> {
			int time = 1;
			while(time <= 10) {
				buffer.put(Integer.toString(time++));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			int time = 1;
			while(time <= 10) {
				buffer.remove();
				time++;
			}
		}).start();
	}
	
}
