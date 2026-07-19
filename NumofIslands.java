// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach : 
// 1. We will traverse the grid and whenever we encounter a '1',
//  we will increment the count of islands and call a DFS function to mark all connected '1's as visited (  by changing them to '0').
// 2. The DFS function will check the boundaries and if the current cell is '1', it will mark it as visited and recursively call DFS for all 4 directions (up, down, left, right).
//  then we return the count of islands after traversing the entire grid.
class Solution {

    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int numIslands(char[][] grid) {

        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

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


    private void dfs(char[][] grid, int r, int c) {

        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m ||
            c < 0 || c >= n ||
            grid[r][c] != '1') {

            return;
        }

        // Mark visited
        grid[r][c] = '0';

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(grid, nr, nc);
        }
    }
}