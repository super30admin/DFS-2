//time: O(N*M): N rows and M cols
//space: O(N+M)
class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        int row= grid.length;
        int col= grid[0].length;
        
        for(int i=0; i<row; i++){
            
            for(int j=0; j<col; j++){
                
                if(grid[i][j]=='1'){
                    res+=dfs(grid,i,j);
                }
            }
        }
        
        return res;
        
    }
    
    public int dfs(char[][] grid, int i, int j){
        
        //boundary check
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]=='0') return 0;
        
        grid[i][j]='0';
        
        dfs(grid, i+1, j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        
        return 1;
        
    }
}