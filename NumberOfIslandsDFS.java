package DFS2;

/*
DFS
Time Complexity: O(m * n)
Space Complexity: O(m * n) */

public class NumberOfIslandsDFS {
	int dirs[][];
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c, int m, int n) {
        //Base
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] != '1') return;
        //Logic
        grid[r][c] = '0';
        for(int[] dir: dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;
            dfs(grid, row, col, m, n);
        }
    }
}
