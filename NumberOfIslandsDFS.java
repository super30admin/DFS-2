// Time Complexity : O(m*n) => As we start dfs only when we encounter 1 even if the entire grid matrix is filled with 1, we only perform DFS once
// Space Complexity : O(m*n) // Recusrive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using DFS. Start iterating over gird matrix and soon as 1st 1 is discovered call dfs and convert the cell value to 2 to avoid performing DFS on that cell and check all 4 directions and if 1 is discovered start another dfs along with converting value to 2. In the base condition check if cell value is not 1 or row, column is out of bound simply return. Output will be the number of times the dfs is performed while iterating over grid[][]
 */
class Solution {
    int[][] dirs;
    int m, n;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; //U D L R
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int column) {

        // base
        if (row < 0 || row == m || column < 0 || column == n || grid[row][column] != '1') {
            return;
        }

        // logic
        grid[row][column] = '2';

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = column + dir[1];

            dfs(grid, nr, nc);
        }
    }
}