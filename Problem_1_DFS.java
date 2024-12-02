/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 * 
 */
public class Problem_1_DFS {
	
	 public int numIslands(char[][] grid) {
	        
	        if(grid == null || grid.length == 0){
	            return 0;
	        }
	        
	        int count = 0;
	        for(int i=0; i<grid.length; i++){
	            for(int j=0; j<grid[0].length; j++){
	                if(grid[i][j] == '1'){
	                    count++;
	                    grid[i][j] = '0';
	                    dfs(grid, i, j);
	                }
	            }
	        }
	        
	        return count;
	        
	    }
	    
	    public void dfs(char[][] grid, int i, int j){
	        
	        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	        
	        for(int[] dir : dirs){
	            int r = dir[0] + i;
	            int c = dir[1] + j;
	            
	            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
	                grid[r][c] = '0';
	                dfs(grid, r, c);
	            }
	        }
	    }

}
