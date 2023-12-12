// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//with dfs with a count pointer. apply dfs to each cell until it is surrouned by zero.
//return the count

public class Islands {
    int[][] dirs;
    int count;
    int m, n;

    public int numIslands(char[][] grid) {
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        count = 0;
        m = grid.length;
        n = grid[0].length;

        if (grid == null || grid.length == 0) return 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                dfs(grid, r, c);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Islands solution = new Islands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int islands = solution.numIslands(grid);
        System.out.println("Number of Islands: " + islands);
    }
}

