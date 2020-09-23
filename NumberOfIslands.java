// Time Complexity :O(MN) M = no of rows in grid, N = no of rcolumns in grid
// Space Complexity : O(MN) Length of the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Traverse through the grid and if you encounter with '1' then replace it with '0'. Also check fir it's neighbors
//count the islands by keeping the count.

public class NumberOfIslands {
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;

    }

    public void helper(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            helper(grid, x, y);
        }
    }

    public static void main(String args[]) {
        NumberOfIslands obj = new NumberOfIslands();

        char[][] grid = { { '1', '1', '1', '0' }, { '1', '1', '0', '0' }, { '1', '1', '0', '0' },
                { '1', '0', '0', '1' } };
        System.out.println(obj.numIslands(grid));

    }
}
