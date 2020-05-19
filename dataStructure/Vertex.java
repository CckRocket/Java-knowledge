package com.data.graph;



public class Vertex {
	private static int INITIAL_CAPACITY = 10;
	private int num;
	private int size;
	private int[] adjacentVertexsIndex;
	private int[] weight;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getAdjacentVertexsIndex() {
		return adjacentVertexsIndex;
	}
	
	public void setAdjacentVertexsIndex(int[] adjacentVertexsIndex) {
		this.adjacentVertexsIndex = adjacentVertexsIndex;
	}

	public Vertex(int num) {
		this.num = num;
		size = 0;
		adjacentVertexsIndex = new int[INITIAL_CAPACITY];
		weight = new int[INITIAL_CAPACITY];
	}
	
	public void addEdge(int pointIndex, int theWeight) {
		if(size == weight.length) {
			grow();
		}
		adjacentVertexsIndex[size] = pointIndex;
		weight[size] = theWeight;
		size++;
	}
	private void grow() {
		int[] oldAdj = adjacentVertexsIndex;
		int[] oldWei = weight;
		int[] newAdj = new int[weight.length*2];
		int[] newWei = new int[weight.length*2];
		for(int i = 0; i < size; i++) {
			newAdj[i] = oldAdj[i];
			newWei[i] = oldWei[i];
		}
		adjacentVertexsIndex = newAdj;
		weight = newWei;
	}
	
	public void show() {
		System.out.print(num + ": ");
		for(int i = 0; i < size; i++) {
			System.out.print(adjacentVertexsIndex[i] + " ");
		}
		System.out.println();
	}

	public int getWeight(int theIndex) {
		for(int i = 0; i < size; i++) {
			if(adjacentVertexsIndex[i] == theIndex) {
				return weight[i];
			}
		}
		return -1;
	}
}
