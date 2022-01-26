package dfs2;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	//BFS
	//Time Complexity : O(m*n), where m are rows and n columns
	//Space Complexity : O(min(m, n))
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int numIslands(char[][] grid) {
        // null
        if(grid == null || grid.length == 0)
            return 0;
        
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    q.offer(new int[] {i, j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir: dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
                                q.offer(new int[] {r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
	
	//DFS
	//Time Complexity : O(m*n), where m are rows and n columns
	//Space Complexity : O(m*n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int numIslands1(char[][] grid) {
        // null
        if(grid == null || grid.length == 0)
            return 0;
        
        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int[][] dirs) {
        // base
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        
        // logic
        grid[i][j] = '0';
        for(int[] dir: dirs)
            dfs(grid, i + dir[0], j + dir[1], dirs);
    }
}
