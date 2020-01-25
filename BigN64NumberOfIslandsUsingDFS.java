//Time complexity is O(m*n)
// Space complexity is O(minimum of m and  n) let me know space complexity is correct
// This solution is submitted on leetcode

public class BigN64NumberOfIslandsUsingDFS {
	int row = 0;
	int column = 0;
	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int numIslands(char[][] grid) {
		row = grid.length;
		if (grid == null || row == 0) {
			return 0;
		}
		column = grid[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int m, int n) {
		if (m < 0 || m >= row || n < 0 || n >= column || grid[m][n] == '0')
			return;
		grid[m][n] = '0';
		for (int[] dir : dirs) {
			int r = m + dir[0];
			int c = n + dir[1];
			dfs(grid, r, c);
		}
	}
}