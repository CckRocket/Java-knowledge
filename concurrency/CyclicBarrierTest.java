package com.data.concurr;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		System.out.println("Main Thread starts");
		CyclicBarrier barrier = new CyclicBarrier(5);
		for(int i = 0; i < 5; i++) {
			new Thread( () -> {
				try {
					Thread.sleep( (long)(Math.random() * 5000) );
					System.out.println(Thread.currentThread().getName() + " is waitings");
					barrier.await();
					System.out.println(Thread.currentThread().getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		} 
	}

}
