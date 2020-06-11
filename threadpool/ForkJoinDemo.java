package com.concurr.threadpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		FKTask testTask = new FKTask(0, 10000);
		int result = forkJoinPool.invoke(testTask);
		forkJoinPool.shutdown();
		System.out.println(result);
	}

	public static class FKTask extends RecursiveTask<Integer> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static int limit = 5;
		private int leftVal;
		private int rightVal;
		
		public FKTask(int left, int right) {
			this.leftVal = left;
			this.rightVal = right;
		}
		protected Integer compute() {
			int res = 0;
			boolean fork = ((rightVal - leftVal) > limit);
			if(fork) {
				int mid = (leftVal + rightVal) / 2;
				FKTask leftTask = new FKTask(leftVal, mid);
				FKTask righTask = new FKTask(mid+1, rightVal);
				invokeAll(leftTask, righTask);
				res = leftTask.join() + righTask.join();
			} else {
				System.out.println(Thread.currentThread().getName() + " : " + leftVal + " - " + rightVal);
				for(int i = leftVal; i <= rightVal; i++) {
					res += i;
				}
			}
			return res;
		}
		
	}
}
