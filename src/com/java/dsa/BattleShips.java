package com.java.dsa;

public class BattleShips {

	public static void main(String[] args) {

		char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		System.out.println("No of battleShips: "+ countBattleships(board));
	}

	public static int countBattleships(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return -1;

		int count = 0;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					if ((i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
