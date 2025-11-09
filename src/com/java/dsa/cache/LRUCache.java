package com.java.dsa.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of an LRU (Least Recently Used) Cache.
 * This cache supports O(1) time complexity for both get and put operations.
 * It uses a combination of a HashMap and a Doubly Linked List to achieve this.
 */
public class LRUCache {

    int capacity; // Maximum capacity of the cache
    Map<Integer, LRUNode> cache; // HashMap to store key-node pairs for O(1) access
    LRUDoublyLinkedList dll; // Doubly Linked List to maintain the order of usage

    /**
     * Constructor to initialize the LRUCache with a given capacity.
     *
     * @param capacity The maximum number of elements the cache can hold.
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new LRUDoublyLinkedList();
    }

    /**
     * Retrieves the value of the key if it exists in the cache.
     * Moves the accessed key to the front (most recently used).
     *
     * @param key The key to retrieve the value for.
     * @return The value associated with the key, or -1 if the key does not exist.
     */
    int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        LRUNode node = cache.get(key);
        dll.remove(node); // Remove from its current position
        dll.addFirst(node); // Move to the front (most recently used)
        return node.value;
    }

    /**
     * Inserts a key-value pair into the cache. If the key already exists, updates its value.
     * If the cache exceeds its capacity, evicts the least recently used item.
     *
     * @param key The key to insert or update.
     * @param value The value associated with the key.
     */
    void put(int key, int value) {
        if (cache.containsKey(key)) {
            LRUNode node = cache.get(key);
            node.value = value; // Update the value
            dll.remove(node);
            dll.addFirst(node);
        } else {
            if (cache.size() >= capacity) {
                LRUNode lru = dll.removeLast(); // Evict the least recently used item
                cache.remove(lru.key);
            }
            LRUNode newNode = new LRUNode(key, value);
            dll.addFirst(newNode);
            cache.put(key, newNode);
        }
    }

}

/**
 * Node class representing an entry in the LRUCache.
 * Each node contains a key, value, and pointers to the previous and next nodes.
 */
class LRUNode {
    int key, value; // Key-value pair stored in the node
    LRUNode prev, next; // Pointers to the previous and next nodes

    /**
     * Constructor to initialize an LRUNode with a key and value.
     *
     * @param key The key of the node.
     * @param value The value of the node.
     */
    LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Doubly Linked List class to maintain the order of nodes in the LRUCache.
 * The most recently used node is at the front, and the least recently used node is at the end.
 */
class LRUDoublyLinkedList {
    LRUNode head, tail; // Dummy head and tail nodes to simplify operations

    /**
     * Constructor to initialize the doubly linked list with dummy head and tail nodes.
     */
    LRUDoublyLinkedList() {
        head = new LRUNode(0, 0); // Dummy head
        tail = new LRUNode(0, 0); // Dummy tail

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Adds a node to the front of the list (most recently used position).
     *
     * @param node The node to add.
     */
    void addFirst(LRUNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * Removes a node from the list.
     *
     * @param node The node to remove.
     */
    void remove(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Removes the last node from the list (least recently used position).
     *
     * @return The removed node, or null if the list is empty.
     */
    LRUNode removeLast() {
        if (tail.prev == head)
            return null; // List is empty
        LRUNode lru = tail.prev;
        remove(lru);
        return lru;
    }

}