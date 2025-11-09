package com.java.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * A Trie (prefix tree) data structure for efficient string operations.
 * Supports insertion, search, and prefix matching.
 */
public class Trie {

	/** Root node of the Trie */
	private TrieNode root;

	/** Constructor initializes the root node */
	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Inserts a word into the Trie.
	 * 
	 * @param word the word to insert
	 */
	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.isEndOfWord = true;
	}

	/**
	 * Searches for a word in the Trie.
	 * 
	 * @param word the word to search
	 * @return true if the word exists, false otherwise
	 */
	public boolean search(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				return false;
			}
			node = node.children[index];
		}
		return node.isEndOfWord;
	}

	/**
	 * Checks if there is any word in the Trie that starts with the given prefix.
	 * 
	 * @param prefix the prefix to check
	 * @return true if any word starts with the prefix, false otherwise
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				return false;
			}
			node = node.children[index];
		}
		return true;
	}

	/**
	 * Deletes a word from the Trie if it exists.
	 * 
	 * @param word the word to delete
	 * @return true if the word was deleted, false otherwise
	 */
	public boolean delete(String word) {
		return deleteHelper(root, word, 0);
	}

	private boolean deleteHelper(TrieNode node, String word, int index) {
		if (index == word.length()) {
			if (!node.isEndOfWord)
				return false;
			node.isEndOfWord = false;
			return isEmpty(node);
		}
		char ch = word.charAt(index);
		int idx = ch - 'a';
		if (node.children[idx] == null)
			return false;
		boolean shouldDelete = deleteHelper(node.children[idx], word, index + 1);
		if (shouldDelete) {
			node.children[idx] = null;
			return !node.isEndOfWord && isEmpty(node);
		}
		return false;
	}

	private boolean isEmpty(TrieNode node) {
		for (TrieNode child : node.children) {
			if (child != null)
				return false;
		}
		return true;
	}

	/**
	 * Returns a list of words that start with the given prefix.
	 * 
	 * @param prefix the prefix to search for
	 * @return list of words starting with the prefix
	 */
	public List<String> autocomplete(String prefix) {
		List<String> result = new ArrayList<>();
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			int idx = ch - 'a';
			if (node.children[idx] == null)
				return result;
			node = node.children[idx];
		}
		collectWords(node, prefix, result);
		return result;
	}

	private void collectWords(TrieNode node, String current, List<String> result) {
		if (node.isEndOfWord) {
			result.add(current);
		}
		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null) {
				collectWords(node.children[i], current + (char) ('a' + i), result);
			}
		}
	}

	/**
	 * Inner class representing a node in the Trie.
	 */
	private static class TrieNode {
		/** Array of children nodes, one for each letter a-z */
		TrieNode[] children = new TrieNode[26];
		/** Flag indicating if this node marks the end of a word */
		boolean isEndOfWord = false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("app");
		trie.insert("application");
		trie.insert("bat");
		trie.insert("ball");

		System.out.println("Search 'apple': " + trie.search("apple"));
		System.out.println("Search 'app': " + trie.search("app"));
		System.out.println("Starts with 'app': " + trie.startsWith("app"));
		System.out.println("Autocomplete 'app': " + trie.autocomplete("app"));
		System.out.println("Delete 'app': " + trie.delete("app"));
		System.out.println("Search 'app' after delete: " + trie.search("app"));
		System.out.println("Autocomplete 'app' after delete: " + trie.autocomplete("app"));
	}

}