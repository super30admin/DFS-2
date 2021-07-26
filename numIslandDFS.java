// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int isLandCount = 0;
        dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    isLandCount++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return isLandCount;
        
    }
    
    private void dfs(char[][] grid, int r, int c, int m, int n){
        //base
        if(r<0 || r>= m || c<0 || c>=n || grid[r][c] == '0')
            return;
        
        //logic
        grid[r][c] = '0';
        for(int[] dir: dirs){
            int nR = r + dir[0];
            int nC = c + dir[1];
            dfs(grid, nR, nC, m, n);
        }
    }
}