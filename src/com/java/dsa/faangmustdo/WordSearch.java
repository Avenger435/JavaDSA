package com.java.dsa.faangmustdo;

public class WordSearch {

	public static void main(String[] args) {

		char[][] case1 = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";

		System.out.println("Case1: " + exist(case1, word));
	}

	public static boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, i, j, 0))
					return true;
			}
		}

		return false;
	}

	// Performs depth-first search to check if the word exists starting from board[i][j] and word index s
	private static boolean dfs(char[][] board, String word, int i, int j, int s) {
		// Check for out-of-bounds indices
		if (i < 0 || i == board.length || j < 0 || j == board[0].length)
			return false;

		// Check if current cell matches the current character in word and is not visited
		if (board[i][j] != word.charAt(s) || board[i][j] == '*')
			return false;

		// If all characters are matched, return true
		if (s == word.length() - 1)
			return true;

		// Cache the current cell value to restore later (backtracking)
		final char cache = board[i][j];

		// Mark the cell as visited by setting it to '*'
		board[i][j] = '*';
		// Recursively search in all four directions for the next character
		final boolean isExist = dfs(board, word, i + 1, j, s + 1) // down
				|| dfs(board, word, i - 1, j, s + 1) // up
				|| dfs(board, word, i, j + 1, s + 1) // right
				|| dfs(board, word, i, j - 1, s + 1); // left
		// Restore the cell value after recursion (backtracking)
		board[i][j] = cache;

		// Return true if any direction finds the word
		return isExist;
	}
}