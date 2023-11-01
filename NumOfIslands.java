public class NumOfIslands {
    int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid)
    {
        int count =0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i< m; i++)
        {
            for (int j = 0 ; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int sr, int sc)
    {
        if(grid[sr][sc] == 'x' || grid[sr][sc] == '0')
            return;

        grid[sr][sc] = 'x';
        for(int[] dir : dirs)
        {
            int nr = sr + dir[0];
            int nc = sc + dir[1];

            // bounce check
            if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length)
                continue;

            dfs(grid, nr, nc);
        }
    }
}
