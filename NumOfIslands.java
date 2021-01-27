// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class NumOfIslands {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        int count = 0;
        //loop thru grid, call dfs every time hit island, inc count for every island
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;

                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        //if in bound
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        //directions
        int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        grid[i][j] = '0';
        //reset all island spots to 0 by using dfs
        for(int[] dir : dirs){
            int row = dir[0] + i;
            int col = dir[1] + j;
            dfs(grid, row, col);
        }
    }
}