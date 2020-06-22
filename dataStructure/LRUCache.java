package com.data.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private static final int capacity = 3;
	private Node head;
	private Node tail;
	private Map<Integer, Node> map;

	
	public LRUCache() {
		map = new HashMap<Integer, LRUCache.Node>();
		head = new Node();
		tail = new Node();
		head.next = tail;
		head.pre = null;
		tail.pre = head;
		tail.next = null;
	}
	
	public void put(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			Node pre = node.pre;
			Node next = node.next;
			pre.next = next;
			next.pre = pre;
			
			map.put(key, addNewNode(key));
			return;
		}
		if(map.size() == capacity) {
			removeLast();
			map.put(key, addNewNode(key));
			return;
		}
		map.put(key, addNewNode(key));
	}
	
	
	private Node addNewNode(int key) {
		Node node = new Node();
		node.key = key;
		node.pre = head;
		node.next = head.next;
		node.next.pre = node;
		head.next = node;
		return node;
	}

	private void removeLast() {
		int key = tail.pre.key;
		map.remove(key);
		tail.pre.pre.next = tail;
		tail.pre = tail.pre.pre;
	}
	
	public void show() {
		System.out.println("----------");
		for(Node curr = head.next; curr != tail; curr = curr.next) {
			System.out.print(curr.key + "-->");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		cache.put(7);
		cache.show();
		cache.put(0);
		cache.show();
		cache.put(1);
		cache.show();
		cache.put(2);
		cache.show();
		cache.put(0);
		cache.show();
		cache.put(3);
		cache.show();
		cache.put(0);
		cache.show();
		cache.put(4);
		cache.show();
	}

	class Node {
		int key;
		Node next;
		Node pre;
	}
}
