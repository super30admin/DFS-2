// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
class Number_of_Islands_DFS {
	int count;
	int direction[][];

	public int numIslands(char[][] grid) {
		direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
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

	private void dfs(char grid[][], int i, int j) {
		// base
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == '2') {
			return;
		}
		// logic
		grid[i][j] = '2';
		for (int dir[] : direction) {
			int r = dir[0] + i;
			int c = dir[1] + j;
			dfs(grid, r, c);
		}
	}
}