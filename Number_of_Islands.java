/*************************************Using BFS***********************************************/
// Time Complexity : O(M * N) 
// Space Complexity : O(min(M, N))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Using BFS, By iterating through the grid, Whenever we find a one, we increase the count of islands and 
 * start iterating through all it's neighbors in 4 directions and make them zeros. 
 * In the end, we get all our islands. */

import java.util.*;

class Number_of_IslandsBFS {
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;

		int count = 0;
		int dirs[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == '1'){  // if encountered 1
					count++;    // increase the count only for new island found
					Queue<int[]> q = new LinkedList<>();    // to traverse all neighbors of the island
					q.add(new int[] {i, j});
					grid[i][j] = '0';   // mark it as 0, as it has been visited

					while(!q.isEmpty()){
						int[] curr = q.poll();
						for(int[] dir: dirs){
							int r = curr[0] + dir[0];
							int c = curr[1] + dir[1];
							if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){  
								q.add(new int[] {r, c});
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


/*************************************Using DFS***********************************************/
//Time Complexity : O(M * N) 
//Space Complexity : O(M * N) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

/* Using DFS, By iterating through the grid, Whenever we find a one, we increase the count of islands and 
 * start iterating through all it's neighbors in 4 directions by using recursion and make them zeros. 
 * In the end, we get all our islands. 
 * This approach will be faster because we use recursion stack space instead of an auxiliary data structure*/

class Number_of_IslandsDFS{
	int count;
	public int numIslands(char[][] grid) {
		//edge case
		if(grid == null || grid.length == 0)
			return 0;

		count = 0;

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == '1'){  // if encountered 1
					count++;    // increase the count only for new island found
					dfs(grid, i , j);
				}
			}
		}
		return count;
	}
	private void dfs(char[][] grid, int i, int j){
		//base case
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return;

		//logic
		int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
		grid[i][j] = '0';   // mark visited
		for(int[] dir: dirs){
			int r = i + dir[0];
			int c = j + dir[1];
			dfs(grid, r, c);    //call dfs on all neighbors
		}
	}
}