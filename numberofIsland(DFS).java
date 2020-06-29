// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    int m;
    int n;
    int [][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 )return 0;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0 ; i< m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                                     
                }
            }
           
        } return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        
        if(i< 0 || j<0  || i>=m ||  j>=n ||  grid[i][j] == '0' )return;
        
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int h = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid , h, c);
        }
        
    }
}
