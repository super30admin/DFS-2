
//BFS Approach
// Time Complexity :2(m*n) = O(m*n)
// Space Complexity : min(m*n) : min of longest diagonal path in matrix for BFS
// Did this code successfully run on Leetcode : yes

public class Island {
	    public int numIslands(char[][] grid) {
	        if (grid == null|| grid.length == 0) return 0;
	        int m = grid.length; int n = grid[0].length;
	        int count = 0;
	        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}}; 
	        Queue <int []> q = new LinkedList<>();
	        for (int i = 0; i < m;i++){
	            for (int j = 0; j < n ; j++){
	                if(grid[i][j] == '1'){
	                    count += 1;
	                    q.add(new int[] {i,j});
	                    while(!q.isEmpty()){
	                        int [] curr = q.poll();
	                        for (int [] dir : dirs){
	                            int r = curr[0] + dir[0];
	                            int c = curr[1] + dir[1];
	                            if(r>=0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
	                                grid[r][c] = '0';
	                                q.add(new int[] {r,c});    
	                            }
	                        }
	                    }
	                }     
	            }
	        }
	        return count;
	    }
	}        
	    