//Time: O(N)
//Space:O(N)
class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {

                    DFS(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void DFS(char[][] grid, int i, int j) {
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        grid[i][j] = '0';

        for (int[] dir : dirs) {

            int r = dir[0] + i;
            int c = dir[1] + j;

            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1')
                DFS(grid, r, c);

        }

    }
}