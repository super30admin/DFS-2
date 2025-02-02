public class Solution
{
    public int NumIslands(char[][] grid)
    {
        if (grid == null || grid.Length == 0)
        {
            return 0;
        }

        int count = 0;
        int m = grid.Length;
        int n = grid[0].Length;
        int[][] dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != '1')
                {
                    continue;
                }
                count++;
                Queue<int[]> queue = new Queue<int[]>();
                queue.Enqueue(new int[2] { i, j });
                grid[i][j] = '2';

                while (queue.Count > 0)
                {
                    var cell = queue.Dequeue();
                    foreach (var dir in dirs)
                    {
                        var newRow = cell[0] + dir[0];
                        var newCol = cell[1] + dir[1];
                        if (newRow < 0 || newRow == m || newCol < 0 || newCol == n || grid[newRow][newCol] != '1')
                        {
                            continue;
                        }
                        queue.Enqueue(new int[2] { newRow, newCol });
                        grid[newRow][newCol] = '2';
                    }
                }
            }
        }
        return count;
    }
}