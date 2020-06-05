package com.data.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
	private String[] arr;
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	private int size;
	private int putIndex;
	private int getIndex;

	public BoundedBuffer() {
		arr = new String[10];
		lock = new ReentrantLock();
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
		size = 0;
		putIndex = 0;
		getIndex = 0;
	}

	public void put(String string){
		lock.lock();
		try {
			while(size == arr.length) {
				notFull.await();	//等着不满
			}
			arr[putIndex] = string;
			putIndex++;
			size++;
			if(putIndex == arr.length) {
				putIndex = 0;
			}
			System.out.println("put " + string + " into buffer");
			notEmpty.signalAll();	//唤醒等待容器非空的线程
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String remove() {
		String res = null;
		lock.lock();
		try {
			while(size == 0) {
				notEmpty.await();	//等待非空
			}
			res = arr[getIndex];
			arr[getIndex] = null;
			getIndex++;
			size--;
			if(getIndex == arr.length) {
				getIndex = 0;
			}
			System.out.println("\t\t\tget " + res + " from buffer");
			notFull.signalAll();	//唤醒等待集合非空的线程
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return res;
	}
}
