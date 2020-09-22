
public class Problem1 {
	 public int numIslands(char[][] grid) {
	       if (grid == null || grid.length == 0) {
	             return 0;
	          }
	        int n=grid.length;
	        int m=grid[0].length;
	        int maxisland=0;
	     
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(grid[i][j]=='1'){
	                    dfs(grid,n,m,i,j);
	                    maxisland++;
	                }
	            }
	        }
	        
	        return maxisland;
	    }
	    
	    private void dfs(char[][] grid, int n,int m,int i,int j){
	        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0')
	            return;
	        
	        grid[i][j]='0';
	      
	        dfs(grid,n,m,i+1,j);
	        dfs(grid,n,m,i-1,j);
	        dfs(grid,n,m,i,j+1);
	        dfs(grid,n,m,i,j-1);
	        
	     
	    }
}
