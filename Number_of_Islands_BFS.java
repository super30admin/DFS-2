// Time Complexity : O(M*N)
// Space Complexity : O(Min(M,N)*Min(M,N))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class Number_of_Islands_BFS {
	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid == null)
			return 0;
		Queue<int[]> q = new LinkedList<>();
		int count = 0;
		int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					grid[i][j] = '2';
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int curr[] = q.poll();
						for (int dir[] : directions) {
							int r = dir[0] + curr[0];
							int c = dir[1] + curr[1];
							if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
								grid[r][c] = '2';
								q.add(new int[] { r, c });
							}
						}
					}
				}
			}
		}
		return count;
	}
}