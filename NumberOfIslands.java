package s30Coding;

// Time Complexity :- O(m*n) where m is the number of rows and n is the number of columns in the matrix
//Space Complexity :- O(m*n) where m is the number of rows and n is the number of columns in the matrix

//LeetCode :- Yes
//Logic :- DFS Solution

public class NumberOfIslands {
	  int [][] dirs;
	    int count;
	    public int numIslands(char[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        count = 0;
	        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
	        for(int i =0; i < grid.length; i++){
	            for(int j = 0;j < grid[0].length; j++){
	                if(grid[i][j] == '1'){
	                    count++;
	                    dfs(grid,i,j);
	                    
	                }
	            }
	            
	        }
	        return count;
	        
	    }
	    
	    public void dfs(char[][] grid, int i , int j){
	        if(i < 0 || j < 0 ||  i >= grid.length || j >= grid[0].length || grid[i][j] == '0' ){
	            return;
	        }
	        
	        grid[i][j] ='0';
	        for(int[] dir : dirs){
	            dfs(grid,i + dir[0],j + dir[1]);
	        }
	    }
}
