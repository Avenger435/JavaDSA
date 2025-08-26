package com.java.dsa.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LFUCache implements a Least Frequently Used (LFU) cache with O(1) time
 * complexity for both get and put operations.
 * 
 * The cache evicts the least frequently used item when it reaches its capacity.
 * If multiple items have the same frequency, the least recently used one is
 * evicted first.
 * 
 * Internal Structure: - Uses two hash maps: - keyToNode: Maps keys to their
 * corresponding cache nodes. - freqDLL: Maps frequencies to doubly linked lists
 * of nodes with that frequency. - Each node stores its key, value, and current
 * frequency. - minFreq tracks the minimum frequency of all nodes in the cache.
 * 
 * Public Methods: - LFUCache(int capacity): Initializes the cache with the
 * given capacity. - int get(int key): Returns the value of the key if present,
 * otherwise returns -1. Increases the frequency of the accessed node. - void
 * put(int key, int value): Inserts or updates the value for the key. If the
 * cache is at capacity, evicts the least frequently used node.
 * 
 * Private Methods: - void increaseFreq(Node node): Increases the frequency of
 * the given node and moves it to the appropriate frequency list. - void
 * evictLFUNode(): Removes the least frequently used node from the cache.
 */
public class LFUCache {

	private int capacity, minFreq;
	private Map<Integer, LFUNode> keyToNode;
	private Map<Integer, LFUDoublyLinkedList> freqDLL;

	/**
	 * Constructs an LFUCache with the specified capacity. Initializes the minimum
	 * frequency, key-to-node mapping, and frequency-to-doubly-linked-list mapping.
	 *
	 * @param capacity the maximum number of items the cache can hold
	 */
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.minFreq = 0;
		this.keyToNode = new HashMap<>();
		this.freqDLL = new HashMap<>();

	}

	/**
	 * Retrieves the value associated with the specified key from the LFU cache. If
	 * the key exists, its frequency is increased and the value is returned. If the
	 * key does not exist, returns -1.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value associated with the key if present; otherwise, -1
	 */
	int get(int key) {
		if (!keyToNode.containsKey(key))
			return -1;
		LFUNode node = keyToNode.get(key);
		increaseFreq(node);
		return node.value;
	}

	/**
	 * Inserts a key-value pair into the LFU cache. If the key already exists,
	 * updates its value and increases its frequency. If the cache reaches its
	 * capacity, evicts the least frequently used node before inserting the new
	 * key-value pair. If the cache capacity is zero, the method does nothing.
	 *
	 * @param key   the key to insert or update in the cache
	 * @param value the value associated with the key
	 */
	void put(int key, int value) {
		if (capacity == 0)
			return;
		if (keyToNode.containsKey(key)) {
			LFUNode node = keyToNode.get(key);
			node.value = value;
			increaseFreq(node);
		} else {
			if (keyToNode.size() >= capacity) {
				evictLFUNode();
			}
			LFUNode newNode = new LFUNode(key, value);
			keyToNode.put(key, newNode);
			minFreq = 1;
			freqDLL.computeIfAbsent(1, k -> new LFUDoublyLinkedList()).addFirst(newNode);
		}

	}

	/**
	 * Increases the frequency count of the given node in the LFU Cache.
	 * <p>
	 * This method removes the node from its current frequency list, increments its
	 * frequency, and adds it to the corresponding new frequency list. If the node
	 * was the only one with the minimum frequency, the minimum frequency counter is
	 * updated.
	 *
	 * @param node the node whose frequency is to be increased
	 */
	private void increaseFreq(LFUNode node) {
		int oldFreq = node.freq;
		LFUDoublyLinkedList oldList = freqDLL.get(oldFreq);
		oldList.remove(node);

		if (oldFreq == minFreq && oldList.isEmpty()) {
			minFreq++;
		}
		node.freq++;
		freqDLL.computeIfAbsent(node.freq, k -> new LFUDoublyLinkedList()).addFirst(node);
	}

	/**
	 * Removes the least frequently used (LFU) node from the cache. This method
	 * identifies the doubly linked list corresponding to the current minimum
	 * frequency, removes the least recently used node from that list, and updates
	 * the key-to-node mapping accordingly. It is typically called when the cache
	 * reaches its capacity and an eviction is required.
	 */
	private void evictLFUNode() {
		LFUDoublyLinkedList minFreqList = freqDLL.get(minFreq);
		LFUNode toRemove = minFreqList.removeLast();
		keyToNode.remove(toRemove.key);
	}

}

class LFUNode {
	int key, value, freq;
	LFUNode prev, next;

	LFUNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.freq = 1;
	}

}

/**
 * DoublyLinkedList is a helper data structure for the LFU Cache implementation.
 * It maintains a doubly linked list of Node objects with dummy head and tail
 * nodes to simplify insertion and removal operations.
 * 
 * Main features: - addFirst(Node node): Inserts a node at the beginning of the
 * list. - remove(Node node): Removes a specific node from the list. -
 * removeLast(): Removes and returns the last node in the list. - isEmpty():
 * Checks if the list is empty.
 * 
 * The list keeps track of its size and provides efficient O(1) operations for
 * insertion and removal.
 */
class LFUDoublyLinkedList {
	LFUNode head, tail;
	int size;

	LFUDoublyLinkedList() {
		head = new LFUNode(0, 0);// dummy head
		tail = new LFUNode(0, 0); // dummy tail
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	void addFirst(LFUNode node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
		size++;
	}

	void remove(LFUNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
	}

	LFUNode removeLast() {
		if (size == 0)
			return null;
		LFUNode last = tail.prev;
		remove(last);
		return last;
	}

	boolean isEmpty() {
		return size == 0;
	}

}