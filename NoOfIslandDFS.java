// Time Complexity : O(m*n)
// Space Complexity : O(m*n) - Recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to practice such problems more


// Your code here along with comments explaining your approach

// Iterate the matrix and run dfs; during dfs mark nodes as visited.\
// each complete dfs means that one island is traversed

class Solution {
    int count = 0;
    int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)  return 0;    
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    // grid[i][j] = '0';
                    count++;
                    dfs(grid, i, j, m,n);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid , int i, int j, int m, int n){
        //base
        if(i <0 || i>=m || j<0 || j>=n || grid[i][j] == '0')
            return;

        //logic
        
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            
            dfs(grid, nr, nc, m, n);
        }
        
    }
}