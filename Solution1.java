//Time Complexity: O(mn)
//Space Complexity: O(mn)


class Solution1 {
    boolean[][] isVisited;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == '1' && !isVisited[i][j] ) {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int i , int j) {
        isVisited[i][j] = true;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if( x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1' && !isVisited[x][y] ) {
                dfs(grid, x, y);
            }
        }
    }
}