package com.java.dsa.cache;

public class LFUTest {

	public static void main(String[] args) {

		LFUCache lfu = new LFUCache(2);

		lfu.put(1, 10); // cache = {1=10}
		lfu.put(2, 20); // cache = {1=10, 2=20}
		System.out.println(lfu.get(1)); // returns 10, freq of key 1 -> 2

		lfu.put(3, 30); // key 2 is LFU, evicted. cache = {1=10, 3=30}
		System.out.println(lfu.get(2)); // returns -1 (not found)
		System.out.println(lfu.get(3)); // returns 30, freq of key 3 -> 2
		lfu.put(4, 40); // key 1 is LFU, evicted. cache = {3=30, 4=40}

		System.out.println(lfu.get(1)); // returns -1
		System.out.println(lfu.get(3)); // returns 30
		System.out.println(lfu.get(4)); // returns 40

	}

}
