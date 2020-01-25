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

// BFS
// BFS
class Solution {
    public int numIslands(char[][] grid) {
		if(grid == null || grid.length==0) return 0;
		int num_islands =0;
		int nr= grid.length;
		int nc = grid[0].length;
        	int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
		for(int i=0;i < nr;i++) {
			for(int j=0;j < nc;j++) {
				if(grid[i][j]=='1') {
					++num_islands;
				    Queue<int[]> q = new LinkedList<>();
				    q.add(new int[]{i,j});
				    //grid[i][j] = '0';
				    while(!q.isEmpty()){
					int[] curr = q.poll();
					grid[curr[0]][curr[1]] = '0';
					for(int[] dir: dirs){
					    int r = curr[0] + dir[0];
					    int c = curr[1] + dir[1];
					    if(r >= 0 && r < nr && c >= 0 && c < nc && grid[r][c] =='1'){
						q.add(new int[]{r,c});
						grid[r][c] = '0';    
					    }
					}   
				    }
				}
			}
		}
		return num_islands;
	}
}
