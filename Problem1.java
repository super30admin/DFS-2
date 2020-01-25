// DFS Solution
// Time Complexity : O(mn) where m is the number of rows and n is the number of columns in the grid
// Space Complexity : O(1) if recursive stack memory is not considered for space
// This Solution worked on LeetCode

class Solution {
    int[][] dirs ={{1,0},{0,1},{-1,0},{0,-1}};
    int m =0;
    int n =0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) return 0;
        m = grid.length;
        n = grid[0].length;
		int num_islands =0;
		for(int i=0;i < m;i++) {
			for(int j=0;j < n;j++) {
				if(grid[i][j]=='1') {
					++num_islands;
					dfs(grid,i,j);
				}
			}
		}
		return num_islands;
	}
	
	public void dfs(char[][] grid,int r,int c) {
		if(r<0 || r>=m || c<0 || c>=n || grid[r][c] =='0')
			return;
		grid[r][c] ='0';
        for(int[] dir : dirs){
            int i = r + dir[0];
            int j = c + dir[1];
            dfs(grid,i,j);
        }
	}
}
