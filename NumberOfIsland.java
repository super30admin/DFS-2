public class NumberOfIsland {
//Time Complexity: O(n)
//Space Complexity: O(1)
    int[][] dirs;
    public int numIslands(char[][] grid) {
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length, column = grid[0].length, count = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            dfs(grid, nr, nc);
        }
    }
}
