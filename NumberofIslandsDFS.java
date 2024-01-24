/*
* Approach:
*  1. Iterate over grid and find the element with "1". 
        Start the DFS (four directions) and convert the elements into 0.
        Once all the directions are made 0, DFS stops.

        This is counted as one island.
* 
*  2. Continue iterating over grid and find element with "1",
        and repeat the process again till all elements are "0".
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O((m*n) * (m*n))
        m*n for iterating
        m*n for DFS
* 
* Space Complexity: O(m*n)
        m*n - max dfs level   
* 
*/

public class NumberofIslandsDFS {
    int islands = 0;

    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void dfs(char[][] grid, int row, int col, int m, int n) {
        for (int[] dir : dirs) {
            int nr = dir[0] + row;

            int nc = dir[1] + col;

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                grid[nr][nc] = '0';
                dfs(grid, nr, nc, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col, m, n);
                    islands++;
                }
            }
        }

        return islands;
    }
}
