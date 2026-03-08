// Time complexity: O(n * m)
// space complexity: O(max(m, n))
// Ran succesfully on Leetcode: yes

class Solution {
    // initialize the neighbor directions
    int [][] dirs = new int [][] {{-1, 0},{0, 1}, {1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if we find an island mark it as visited and perform dfs on all the connected islands
                if(grid[i][j] == '1') {
                    islands++;
                    grid[i][j]='0';
                    dfsIslands(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void dfsIslands(char [][]grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        for (int [] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            // mark as visited perform dfs on all the connected islands
            if(r >= 0 && r <m && c >= 0 && c < n && grid[r][c] == '1') {
                grid[r][c] = '0';
                dfsIslands(grid, r, c);
            }

        }
    }
}