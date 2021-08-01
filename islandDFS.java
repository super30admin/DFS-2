// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//space O(MN); time O()
class islands {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    helper(grid, i, j, m, n);
                }
            }
        }
        return islandCount;
    }
    
    private void helper(char[][] grid, int row, int col, int m, int n){
        
        //base
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0'){
            return;
        }
        //logic
        grid[row][col] = '0';
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            helper(grid, nr, nc, m , n);
        }
        
        
    }
}