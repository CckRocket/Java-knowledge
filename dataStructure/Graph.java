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
	private void dfs(Vertex vertex, boolean[] visited) {
		System.out.print(vertex.getNum() + " ");
		visited[vertex.getNum()] = true;
		int[] adj = vertex.getAdjacentVertexsIndex();
		for(int i = 0; i < vertex.getSize(); i++) {
			if(visited[adj[i]] == false) {
				dfs(vertexs[adj[i]], visited);
			}
		}
	}
	
	public void bfs() {
		if(vertexs.length == 0) {
			return;
		}
		System.out.print("BFS: ");
		boolean[] visited = new boolean[vertexs.length];
		Arrays.fill(visited, false);
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
	
	public void dijkstra(int starter) {
		int[] distance = new int[vertexs.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i = 0; i < distance.length; i++) {
			if(i == starter) {
				distance[i] = 0;
			}else {
				int weight = vertexs[starter].getWeight(i);
				if(weight != -1) {
					distance[i] = weight;
				}
			}
		}
		boolean[] visited = new boolean[vertexs.length];
		visited[starter] = true;
		for(int itrTime = 0; itrTime < vertexs.length - 1; itrTime++) {
			//find the minimum-distance vertex to starter which is not visited
			int minIndex = 0;
			int minDist = Integer.MAX_VALUE;
			for(int i = 0; i < distance.length; i++) {
				if(visited[i] == false && distance[i] < minDist) {
					minIndex = i;
					minDist = distance[i];
				}
			}
			int[] adj = vertexs[minIndex].getAdjacentVertexsIndex();
			for(int i = 0; i < adj.length; i++) {
				int tempDist = vertexs[minIndex].getWeight(adj[i]);
				if(tempDist != -1 && distance[adj[i]] > minDist + tempDist) {
					distance[adj[i]] = minDist + tempDist;
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


	public void show() {
		for(Vertex v : vertexs) {
			v.show();
		}
	}
}
