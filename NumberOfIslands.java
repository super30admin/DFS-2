// TIME: O(M * N)
// SPACE: O(M * N)
// SUCCESS on LeetCode

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(i,j,grid);
                }
            }
        }
        return noOfIslands;
    }
    
    private void dfs(int r, int c, char[][] grid) {
        // base
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if (grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        //recursion logic
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);
        dfs(r+1,c,grid);
        dfs(r-1, c,grid);
    }
}
