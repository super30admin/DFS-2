//TC: O(m*n)
//SC: O(m)
public class IslandProblem {
    int[][] dirs;
    int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dirs= new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int m, int n, int i, int j) {
        if(j < 0 || i < 0 || i == m || j == n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, m, n, r, c);
        }
    }
}
