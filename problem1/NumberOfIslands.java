//Time Complexity : O(m*n), m -> Number of rows, n -> Number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.Stack;

public class NumberOfIslands {
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
					Stack<int[]> stack = new Stack<int[]>();
					stack.push(new int[] { i, j });
					visited[i][j] = true;

					while (!stack.isEmpty()) {
						int[] curNode = stack.pop();
						for (int[] dir : dirs) {
							int r = curNode[0] + dir[0];
							int c = curNode[1] + dir[1];

							if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1' && !visited[r][c]) {
								stack.push(new int[] { r, c });
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
