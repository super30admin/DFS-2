
//Tc - O(m*n)
//SC - O(m*n)
class Solution1 {
	public static int numIslands(char[][] grid) {
		int numOfIslands = 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					numOfIslands++;
					dfs(grid, i, j, directions); // dfs
				}
			}
		}
		return numOfIslands;
	}

	private static void dfs(char[][] grid, int nr, int nc, int[][] directions) {
		// base
		if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == '0') {
			return;
		}
		// logic
		grid[nr][nc] = '0';
		for (int[] dir : directions) {
			dfs(grid, dir[0] + nr, dir[1] + nc, directions);
		}
	}
}

public class NumberofIslands_DFS {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		Solution1 s = new Solution1();
		System.out.println(s.numIslands(grid));
	}

}
