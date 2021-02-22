class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null ||  grid[0] == null || grid.length == 0 || grid[0].length == 0 ){
        return 0;
        }
        
        int count = 0;
        int n = grid.length; int m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count = count + 1;
                }
            }
        }
        return count;
    }
    
    private int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
    
    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[0];
            
            if(r >= 0 && r<grid.length && c>=0 && c < grid[0].length && grid[r][c] == '1'){
                dfs(grid, r, c);
            }
        }
    }
}
