// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * 
 * https://leetcode.com/problems/number-of-islands/
 *
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {

		if(grid == null || grid.length ==0) return 0;

		Queue<int[]> q = new LinkedList<>();

		int m = grid.length, n = grid[0].length;
		int cnt = 0;

		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

		//m*n 
		for(int i=0;i<m;i++){
			for(int j=0; j<n;j++){

				//if current val 1, add this node to queue for bfs processing (node of bfs)
				if(grid[i][j] == '1') {
					//increase island count (island that includes current node)
					cnt++;
					grid[i][j] = '0';
					q.add(new int[] {i,j});

					while(!q.isEmpty()) {
						int[] loc = q.poll();

						for(int[] dir: dirs){
							int r = loc[0] + dir[0];
							int c = loc[1] + dir[1];

							if(r >=0 && r <m && c>= 0 && c < n && grid[r][c] == '1') {
								grid[r][c] ='0';
								q.add(new int[] {r,c});
							}    
						}
					}
				}
			}
		}

		return cnt;


	}
}
