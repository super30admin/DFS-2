// TC: O(m x n)
// SC: O(m x n)
class Solution {
    int m, n;

    int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        // base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') {
            return;
        }

        // logic
        grid[i][j] = '0';
        for(int[] d : dir) {
            int r = d[0] + i;
            int c = d[1] + j;
            dfs(grid, r, c);
        }
    }
}