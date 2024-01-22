//TC = O(2m*n)
//SC = O(m*n)
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid, i, j, m, n);

                }
            }
        }
        return count;
        }
        void dfs(char[][] grid, int i, int j, int m, int n)
        {
            if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
            grid[i][j] = '0';
            for(int[] dir: dirs)
            {
                int nr = i + dir[0];
                int nc = j + dir[1];
                dfs(grid, nr, nc, m, n);
            }
        }
        
    
}