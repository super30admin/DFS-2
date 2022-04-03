// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
public class NumOfIslands {	
	int count;
    int m; int n;
    int[][] dirs;
    /**Approach1: DFS | Time O(m*n) | Space O(m*n) **/
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        
        m= grid.length;
        n= grid[0].length;
        count=0;     
        dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};//right,down,left,up
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }      
    private void dfs(char[][] grid, int i, int j){
        //base
    	if(grid[i][j]=='0') return;    	      
        
        //logic
        grid[i][j]='0';  
        for(int[] dir: dirs){
            int r= i+dir[0];
            int c= j+dir[1];   
            //bounce check
            if(r>=0 && c>=0 && r<m && c<n && grid[r][c]=='1'){
                dfs(grid, r, c);
            }            
        }
    }
    
	// Driver code to test above 
	public static void main (String[] args) {
		NumOfIslands ob= new NumOfIslands();
		/*char[][] grid= {{'1','1','1','1','0'},
						{'1','1','0','1','0'},
						{'1','1','0','0','0'},
						{'0','0','0','0','0'}};*/
		char[][] grid= {{'1','1','0','0','0'},
				  		{'1','1','0','0','0'},
				  		{'0','0','1','0','0'},
				  		{'0','0','0','1','1'}};
		System.out.println("Number of islands in grid : "+ ob.numIslands(grid));	
		
	}
}
