package com.data.concurr;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

	public static void main(String[] args) {
		Callable<Integer> callable = (() -> {
			System.out.println("Computation Thread execution starts");
			Thread.sleep(4000);
			int res = (int) (Math.random() * 1000);
			System.out.println("Computation Thread execution ends");
			return res;
		});
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		new Thread(futureTask).start();
		
		try {
			System.out.println(futureTask.get(100,TimeUnit.MILLISECONDS));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
