package dfs;

// TC: O(r*c)
// SC: O(1)
public class NumberOFIslandsWithoutVisited {
	// use DFS
	// use visited array
	// Start from leftmost and check if not visited, increment count for not visited
	// and dont check if grid[i][j] == 0 otherwise check all 4 directions 

	public int numIslands(char[][] grid) {

		if (grid.length == 0)
			return 0;
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					numsIslandsDFSModified(i, j, grid);
				}

			}
		}

		return count;
	}

	public void numsIslandsDFSModified(int row, int col, char[][] grid) {
		grid[row][col] = 0;

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] dir : directions) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];

			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
				if (grid[newRow][newCol] == '1')
					numsIslandsDFSModified(newRow, newCol, grid);
			}
		}
	}

}