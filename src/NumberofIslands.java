import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity of the algorithm is O( 2 (m*n)) where m is no. of rows and n is no. of column.
 * space Complexity is O(Math.min(m,n))  where m is no. of rows and n is no. of column.
 */

public class NumberofIslands {

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int n = grid[0].length, m = grid.length;
		int ans = 0;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (grid[i][j] == '1') {

					ans++;
					grid[i][j] = '0';
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {

						int[] curr = q.poll();

						for (int[] dir : dirs) {

							int r = dir[0] + curr[0];
							int c = dir[1] + curr[1];

							if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {

								grid[r][c] = '0';
								q.add(new int[] { r, c });
							}
						}

					}

				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
