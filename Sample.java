// Time Complexity : O(M*N)
// Space Complexity : O(M*N) for recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Iterate till first 1 is found and increment count. From there apply dfs. Mark
 * that index as 0 and then check its adjacent indices. If any of its adjacent
 * nodes are 1, apply dfs on those nodes recursively. Once all nodes are
 * covered, then find the next 1. Return total count.
 *
 */
class Solution {
	int[] x4 = { 0, 1, 0, -1 };
	int[] y4 = { 1, 0, -1, 0 };

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	public void dfs(char[][] grid, int i, int j) {
		if (grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		for (int t = 0; t < 4; t++) {
			int x = i + x4[t];
			int y = j + y4[t];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
				dfs(grid, x, y);
			}
		}
	}
}