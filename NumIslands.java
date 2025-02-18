// Time Complexity : O (m x n)
// Space Complexity : O (m x n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
public class NumIslands {
    int count = 0;
    char[][] grid;
    int nRows, nCols;

    // recursive dfs function
    void dfs(int i, int j) {
        // if out of bounds, or if cell is '0', return from dfs
        if(i < 0 || j < 0 || i >= nRows || j >= nCols || grid[i][j] == '0') {
            return;
        }

        // set cell to '0' to mark it as 'visited'
        else grid[i][j] = '0';

        // go to all the neighbors and perform dfs on each
        // (if oob or 0, they will return)
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
    public int numIslands(char[][] grid) {
        int i, j;
        nRows = grid.length;
        nCols = grid[0].length;
        this.grid = grid;
        for(i = 0; i < nRows; i++) {
            for(j = 0; j < nCols; j++) {
                // iterate over all cells
                if(this.grid[i][j] == '1') {
                    // if '1', increment island count (as dfs will mark all adj cells as '0')
                    count++;
                    // dfs to visit all adj cells
                    dfs(i, j);
                }
            }
        }
        return count;
    }
}
