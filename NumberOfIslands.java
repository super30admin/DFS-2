package dfs2;

/*
Idea :  1. We check recursively if the 4-directional neighbors of a cell are of same value.
 		2. We iterate over the matrix and change the values of land to water and when it stops, 
 		   we increase the count of island.

Time Complexity : O(r*c) because we process whole matrix.
Space Complexity : O(r*c).

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfsFill(grid, i, j);
					count++;
				}
			}
		return count;
	}

	private void dfsFill(char[][] grid, int i, int j) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = '0';
			dfsFill(grid, i + 1, j);
			dfsFill(grid, i - 1, j);
			dfsFill(grid, i, j + 1);
			dfsFill(grid, i, j - 1);
		}
	}
}
