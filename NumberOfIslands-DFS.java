class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return count;
        }
        
       
        
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1'){
                   dfs(grid,n,m,i,j);
                   count +=1;
                }
                
            }
        }
        
        return count;
        
    }
    
    private void dfs(char[][] grid, int n, int m,int i, int j){
        
        grid[i][j] = '0';
        
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
        
        for (int[] directions : dirs){
            int r = i + directions[0];
            int c = j + directions[1];
            
            if (r >=0 && r < n && c >=0 && c < m && grid[r][c] == '1'){
                dfs(grid, n,m,r,c);
                
            }
        }
        
        
    }
}