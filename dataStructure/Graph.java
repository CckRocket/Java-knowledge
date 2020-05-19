package com.data.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private Vertex[] vertexs;
	
	public Graph(int size) {
		vertexs = new Vertex[size];
		for(int i = 0; i < vertexs.length; i++) {
			vertexs[i] = new Vertex(i);
		}
	}
	
	public void addEdge(int start, int end, int weight) {
		int len = vertexs.length;
		if(start >= len || start < 0 || end >= len || end < 0 || weight < 0) {
			return;
		}
		vertexs[start].addEdge(end, weight);
		vertexs[end].addEdge(start, weight);
	}
	
	public void dfs() {
		if(vertexs.length == 0) {
			return;
		}
		boolean[] visited = new boolean[vertexs.length];
		Arrays.fill(visited, false);
		System.out.print("DFS: ");
		dfs(vertexs[0], visited);
		System.out.println();
	}
	/**
	 * recusive private DFS function
	 * @param vertex
	 * @param visited
	 */
	private void dfs(Vertex vertex, boolean[] visited) {
		//set current vertex as visited
		System.out.print(vertex.getNum() + " ");
		visited[vertex.getNum()] = true;
		//load adjacent list
		int[] adj = vertex.getAdjacentVertexsIndex();
		for(int i = 0; i < vertex.getSize(); i++) {
			if(visited[adj[i]] == false) {
				dfs(vertexs[adj[i]], visited);
			}
		}
	}
	/**
	 * Queue-Based BFS
	 */
	public void bfs() {
		//no vertex exists
		if(vertexs.length == 0) {
			return;
		}
		System.out.print("BFS: ");
		boolean[] visited = new boolean[vertexs.length];
		Arrays.fill(visited, false);
		//queue initiation with vertex 0
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(vertexs[0]);
		while (!queue.isEmpty()) {
			Vertex v = queue.remove();
			System.out.print(v.getNum() + " ");
			visited[v.getNum()] = true;
			int[] adj = v.getAdjacentVertexsIndex();
			for(int i = 0; i < v.getSize(); i++) {
				if(visited[adj[i]] == false) {
					queue.add(vertexs[adj[i]]);
					visited[adj[i]] = true;
				}
			}
		}
		System.out.println();
	}
	/**
	 * Dijkstra algorithm
	 * @param starter : the index of start vertex
	 */
	public void dijkstra(int starter) {
		//initial distance array
		int verNum = vertexs.length;
		int[] distance = new int[verNum];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i = 0; i < verNum; i++) {
			if(i == starter) {
				distance[i] = 0;
			}else {
				//getWeight costs O(n)
				int weight = vertexs[starter].getWeight(i);
				if(weight != -1) {
					distance[i] = weight;
				}
			}
		}
		//update distance array
		boolean[] visited = new boolean[verNum];
		visited[starter] = true;
		for(int itrTime = 1; itrTime < verNum; itrTime++) {
			//find the minimum-distance vertex to starter which is not visited
			int minIndex = 0;
			int minDist = Integer.MAX_VALUE;
			for(int i = 0; i < verNum; i++) {
				if(visited[i] == false && distance[i] < minDist) {
					minIndex = i;
					minDist = distance[i];
				}
			}
			//update distance array using minIndex
			int[] adj = vertexs[minIndex].getAdjacentVertexsIndex();
			for(int i = 0; i < vertexs[minIndex].getSize(); i++) {
				int min2endDist = vertexs[minIndex].getWeight(adj[i]);
				//if distance(A,B) > distance(A,min) + distance(min,B), then update
				if(min2endDist != -1 && distance[adj[i]] > minDist + min2endDist) {
					distance[adj[i]] = minDist + min2endDist;
				}
			}
			visited[minIndex] = true;
		}
		System.out.print(starter + "  to: \t\t");
		for(int i = 0; i < distance.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.print("distance \t");
		for(int temp : distance) {
			System.out.print(temp + "\t");
		}
		System.out.println();
	}
	/**
	 * display all vertex
	 */
	public void show() {
		for(Vertex v : vertexs) {
			v.show();
		}
	}
}
