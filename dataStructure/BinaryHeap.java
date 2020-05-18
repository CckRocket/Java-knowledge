package com.data.tree;

public class BinaryHeap {
	private static int INITIAL_CAPACITY = 10;
	private int[] data;
	private int size;
	private int capacity;

	public BinaryHeap() {
		data = new int[INITIAL_CAPACITY + 1];
		capacity = INITIAL_CAPACITY;
		size = 0;
	}
	/**
	 * add new data
	 * @param value
	 */
	public void add(int value) {
		ensureCapacity();
		size++;
		int index = size;
		while (index > 1) {
			if(value > data[index/2]) {
				data[index] = data[index/2];
			}
			index /= 2;
		}
		data[index] = value;
	}
	private void ensureCapacity() {
		if(size == capacity) {
			grow();
		}
	}
	private void grow() {
		int[] oldData = data;
		int[] newData = new int[capacity * 2 + 1];
		for(int i = 0; i <= capacity; i++) {
			newData[i] = oldData[i];
		}
		capacity = 2 * capacity;
		data = newData;
	}
	/**
	 * delete the min value
	 * @return
	 */
	public boolean deleteMin() {
		if(size == 0) {
			return false;
		}
		int value = data[size--];
		int index = 1;
		//has children
		while (2*index <= size) {
			//has left child
			if(2*index+1 > size && data[2*index] > value) {
				data[index] = data[2*index];
				index *= 2;
				//has two children
			}else if(2*index+1 <= size && Math.max(data[2*index], data[2*index+1]) > value) {
				//left child is great than right
				if(data[2*index] > data[2*index+1]) {
					data[index] = data[2*index];
					index *= 2;
				//right child is great than left
				}else {
					data[index] = data[2*index+1];
					index = 2*index+1;
				}
			}else{
				break;
			}
		}
		data[index] = value;
		return true;
	}
	/**
	 * print all values
	 */
	public void show() {
		System.out.println("element of Binary Heap: ");
		for(int i = 1, level = 1; i <= size; i++) {
			if(i == (int)Math.pow(2, level-1)) {
				System.out.print("level " + level + " ----");
			}
			System.out.print(data[i] + " ");
			if(i + 1 == (int)Math.pow(2, level)) {
				System.out.println();
				level++;
			}
		}
		System.out.println();
	}
}
