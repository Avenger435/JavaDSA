package com.java.dsa.trees;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		int numOfIslands= numIslands(grid);
		System.out.println(numOfIslands);
		
	}

	public static int numIslands(char[][] grid) {

		if (grid == null || grid[0].length == 0)
			return 0;

		int numRows = grid.length;
		int numCols = grid[0].length;
		int numIslands = 0;

		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if (grid[r][c] == '1') {
					numIslands++;
					dfs(grid, r, c);
				}
			}
		}
		return numIslands;
	}

	private static void dfs(char[][] grid, int r, int c) {
		int numRows = grid.length;
		int numCols = grid[0].length;
		// check for out of bounds or if the current cell is water or already visited.
		if (r < 0 || r >= numRows || c < 0 || c >= numCols || grid[r][c] == '0') {
			return;
		}

		// Mark the current land cell as visited by changing the value to 0
		grid[r][c] = '0';

		dfs(grid, r + 1, c);
		dfs(grid, r - 1, c);
		dfs(grid, r, c + 1);
		dfs(grid, r, c - 1);

	}
}
