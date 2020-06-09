package com.data.concurr;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		System.out.println("Sub Threads start");
		System.out.println("------");
		for(int i = 0; i < 5; i++) {
			new Thread( () -> {
				try {
					System.out.println(Thread.currentThread().getName() + " starts");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					latch.countDown();
					System.out.println(Thread.currentThread().getName() + " finished");
				}
			}).start();
		}
		
		try {
			latch.await(200, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("------");
		System.out.println("Main Thread finished!");
	}

}
