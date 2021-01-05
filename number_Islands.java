class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null){
            return 0;
        }
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    private void dfs(char[][] grid, int r, int c){
        if(r < m && r >= 0 && c < n && c >= 0 && (grid[r][c] !='0')){
            grid[r][c] = '0';
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(grid, nr , nc);
            }    
         }
    }   
}
