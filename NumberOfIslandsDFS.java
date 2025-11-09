/*
Approach: DFS to count islands.
- Iterate through the grid and when '1' (land) is found, increment count and DFS to mark all connected land cells as '0' (visited).
- DFS explores 4-directional neighbors recursively.

Time Complexity: O(m * n) — each cell is visited at most once.
Space Complexity: O(m * n) — recursion stack in worst-case (or O(min(m,n)) typical depth), plus constant extra space.

LeetCode: https://leetcode.com/problems/number-of-islands/
*/
public class NumberOfIslandsDFS {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int cr, int cc) {
        //base
        if (cr < 0 || cc < 0 || cr == grid.length || cc == grid[0].length || grid[cr][cc] == '0') {
            return;
        }
        grid[cr][cc] = '0';
        for (int[] dir : dirs) {
            int c = cr + dir[0];
            int r = cc + dir[1];
            dfs(grid, c, r);
        }
    }


}
