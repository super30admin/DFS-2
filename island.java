// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        
        if (r<0 || c < 0 || r >= nr || c >= nc || grid[r][c] =='0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_island = 0;
        for(int r = 0; r<nr ; r++){
            for(int c=0; c<nc;c++){
                if (grid[r][c] =='1'){
                    num_island++;
                    dfs(grid, r,c);
                } 
            }
        }
        return num_island;
    }
}