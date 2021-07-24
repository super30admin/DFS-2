//Time Complexity : O(m*n), m -> Number of rows, n -> Number of columns
// Space Complexity : O(min(m, n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	int[][] dirs;

	/********************* DFS Approach *********************/
	// Time Complexity : O(m*n), m -> Number of rows, n -> Number of columns
	// Space Complexity : O(m * n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int numIslandsRecursive(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int ans = 0;
		int m = grid.length;
		int n = grid[0].length;
		dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					ans++;
					helper(grid, i, j, m, n);
				}
			}
		}
		return ans;
	}

	public void helper(char[][] grid, int row, int col, int m, int n) {
		if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
			return;
		}

		grid[row][col] = '0';
		for (int[] dir : dirs) {
			helper(grid, row + dir[0], col + dir[1], m, n);
		}
	}

	/********************* BFS Approach *********************/
	// Time Complexity : O(m*n), m -> Number of rows, n -> Number of columns
	// Space Complexity : O(min(m, n))
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int ans = 0;
		int m = grid.length;
		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					Queue<int[]> queue = new LinkedList<int[]>();
					queue.add(new int[] { i, j });
					visited[i][j] = true;

					while (!queue.isEmpty()) {
						int[] curNode = queue.poll();
						for (int[] dir : dirs) {
							int r = curNode[0] + dir[0];
							int c = curNode[1] + dir[1];

							if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1' && !visited[r][c]) {
								queue.add(new int[] { r, c });
								visited[r][c] = true;
							}
						}
					}
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		NumberOfIslands obj = new NumberOfIslands();
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println("Number of islands: " + obj.numIslands(grid));
	}

}
