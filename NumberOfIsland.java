//Time Complexity : O(m*n) for traversing the whole matrix
//Space Complexity :O(m * n) for Stack 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :
public class NumberOfIsland {
	 int m;
	    int n;
	    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	    
	    public int numIslands(char[][] grid) {
	      m = grid.length;
	      n = grid[0].length;
	      int count =0;  
	      
	         for(int i=0;i<m;i++){
	             for(int j=0;j<n;j++){   
	                 if(grid[i][j]=='1'){
	                    count++;
	                    dfs(grid,i,j); 
	                 } 
	             }
	         } 
	        
	        return count;
	    }
	    public void dfs(char[][] grid,int i, int j){
	        // base condition
	        if(i<0 || i==m || j<0 || j==n|| grid[i][j]!='1')
	            return ;
	        
	        //logic
	        grid[i][j] = '2';
	        
	        for(int[] dir: dirs){
	            int ci=dir[0]+i;
	            int cj = dir[1]+j;
	            dfs(grid,ci,cj);
	        }  
	    }
}
