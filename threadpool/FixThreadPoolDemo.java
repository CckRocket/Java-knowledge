package com.concurr.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixThreadPoolDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for(int i = 0; i < 10; i++) {
			executorService.submit(() ->{
				System.out.println(Thread.currentThread().getName());
			});
		}
		executorService.shutdown();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 1; i <= 32; i++) {
			System.out.print(1);
		}
	}
	

}
