//Time complexity is O(m*n)
//Space complexity is O(minimum of m and  n)
//This solution is submitted on leetcode

import java.util.LinkedList;
import java.util.Queue;

public class BigN64NumberOfIslandUsingBFS {
	public int numIslands(char[][] grid) {
		int row = grid.length;
		// edge
		if (grid == null || row == 0) {
			return 0;
		}
		int column = grid[0].length;
		int count = 0;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '1') {
					count++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					grid[i][j] = '0';
					while (!q.isEmpty()) {
						int[] temp = q.poll();
						for (int[] dir : dirs) {
							int r = temp[0] + dir[0];
							int c = temp[1] + dir[1];
							if (r >= 0 && r < row && c >= 0 && c < column && grid[r][c] == '1') {
								q.add(new int[] { r, c });
								grid[r][c] = '0';
							}
						}
					}
				}
			}
		}
		return count;
	}
}