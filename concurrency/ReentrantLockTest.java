package com.data.concurr;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	public static void main(String[] args) {
		ReentrantLockTest test = new ReentrantLockTest();
		new Thread(() -> {
			test.method(true);
			test.method(false);
		}) .start();
	}

	public void method(boolean b) {
		if(b) {
			lock.writeLock().lock();
			try {
				System.out.println("write method invoke");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		}else {
			lock.readLock().lock();
			try {
				System.out.println("read method invoke");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		}
	}

}
