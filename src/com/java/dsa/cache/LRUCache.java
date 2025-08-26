package com.java.dsa.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	int capacity;
	Map<Integer, LRUNode> cache;
	LRUDoublyLinkedList dll;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.dll = new LRUDoublyLinkedList();
	}

	int get(int key) {
		if (!cache.containsKey(key))
			return -1;

		LRUNode node = cache.get(key);
		dll.remove(node); // remove from first position
		dll.addFirst(node);// move to front (most recently used)
		return node.value;
	}

	void put(int key, int value) {
		if (cache.containsKey(key)) {
			LRUNode node = cache.get(key);
			node.value = value;
			dll.remove(node);
			dll.addFirst(node);
		} else {
			if (cache.size() >= capacity) {
				LRUNode lru = dll.removeLast(); // Evict last recently used.
				cache.remove(lru.key);
			}
			LRUNode newNode = new LRUNode(key, value);
			dll.addFirst(newNode);
			cache.put(key, newNode);
		}
	}

}

class LRUNode {
	int key, value;
	LRUNode prev, next;

	LRUNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUDoublyLinkedList {
	LRUNode head, tail;

	LRUDoublyLinkedList() {
		head = new LRUNode(0, 0);// dummy head
		tail = new LRUNode(0, 0);// dummy tail

		head.next = tail;
		tail.prev = head;
	}

	void addFirst(LRUNode node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
	}

	void remove(LRUNode node) {
		node.prev.next = node.next;
		node.prev.prev = node.prev;
	}

	LRUNode removeLast() {
		if (tail.prev == head)
			return null;
		LRUNode lru = tail.prev;
		remove(lru);
		return lru;
	}

}