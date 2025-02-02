public class Solution
{
    int m, n;
    int[][] dirs;
    public int NumIslands(char[][] grid)
    {
        if (grid == null || grid.Length == 0)
        {
            return 0;
        }

        int count = 0;
        m = grid.Length;
        n = grid[0].Length;
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != '1')
                {
                    continue;
                }
                count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col)
    {
        //base
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1')
        {
            return;
        }

        grid[row][col] = '2';
        foreach (var dir in dirs)
        {
            var newRow = row + dir[0];
            var newCol = col + dir[1];
            dfs(grid, newRow, newCol);
        }
    }
}