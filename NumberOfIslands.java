package dfs;

import java.util.Arrays;
// TC: O(r*c)
// SC: O(r*c)
public class NumberOfIslands {
	// use DFS
	// use visited array
	// Start from leftmost and check if not visited, increment count for not visited
	// and dont check if visited otherwise check all 4 directions and mark them
	// visited if any

	public int numIslands(char[][] grid) {

		if (grid.length == 0)
			return 0;
		int count = 0;

		// initialize visited array with 0
		int[][] visited = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(visited[i], 0);
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if ((grid[i][j] == '1') && (visited[i][j] != 1)) {
					count++;
					numIslandsDFS(i, j, grid, visited);
				}

			}
		}

		return count;
	}

	public void numIslandsDFS(int row, int col, char[][] grid, int[][] visited) {

		visited[row][col] = 1;

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] dir : directions) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];

			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
				if ((visited[newRow][newCol] != 1) && (grid[newRow][newCol] == '1'))
					numIslandsDFS(newRow, newCol, grid, visited);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		System.out.println(new NumberOfIslands().numIslands(grid));
	}

}
