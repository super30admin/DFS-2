import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n) where m = number of rows, n = number of columns
// Space Complexity : O(m*n) where m = number of rows, n = number of columns
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//200. Number of Islands (Medium) - https://leetcode.com/problems/number-of-islands/
class Solution {
	
	int[][] dirs;
	
    public int numIslands(char[][] grid) {
    	// Time Complexity : O(m*n) where m = number of rows, n = number of columns
    	// Space Complexity : O(min(m, n)) where m = number of rows, n = number of columns
//        if (grid == null || grid.length == 0) return 0;
//        
//        int m = grid.length, n = grid[0].length, count = 0;
//        
//        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        
//        Queue<int[]> queue = new LinkedList<>();
//        
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == '1') {
//                    count++;
//                    queue.add(new int[]{i, j});
//                    grid[i][j] = '0';
//                    
//                    while (!queue.isEmpty()) {
//                        int[] curr = queue.poll();
//                        
//                        for (int[] dir : dirs) {
//                            int nr = curr[0] + dir[0];
//                            int nc = curr[1] + dir[1];
//                            
//                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
//                                queue.add(new int[] {nr, nc});
//                                grid[nr][nc] = '0';
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        return count;
        
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length, n = grid[0].length, count = 0;

		dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		// base
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return;
		// logic
		grid[i][j] = '0';
		for (int[] dir : dirs) {
			int nr = i + dir[0];
			int nc = j + dir[1];
			dfs(grid, nr, nc);
		}
	}
}