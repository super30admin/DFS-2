// Time Complexity = O (m*n)
// Space Complexity = O (m*n)

class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int [][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
        int count = 0;
        
        for(int i = 0; i<m;i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,grid, dirs, m,n);
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][]  grid, int [][] dirs, int m, int n){
        //base
        if(i < 0 || i== m || j<0 || j == n || grid[i][j] == '0') return;
            
        //logic
        grid[i][j] = '0';
        for(int [] dir:dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(nr,nc,grid,  dirs, m,n);
        }
    }
    
}