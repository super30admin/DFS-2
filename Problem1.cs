public class CountIslands
    {       
        // Time Complexity : O(m * n) - have to traverse entire matrix
        // Space Complexity : O(m * n) - recursive stack will utmost have all elements in matrix 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int NumIslands(char[][] grid)
        {
            if (grid == null || grid.Length == 0) return 0;
            int m = grid.Length;
            int n = grid[0].Length;
            int count = 0;
            int[][] directions = new int[][] {
                new int[] { 0, 1 }, //right
                new int[] { 0, -1 }, //left
                new int[] { 1, 0 }, //down
                new int[] { -1, 0 } //up
            };
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        count++;
                        dfs(grid, i, j, directions, m, n);
                    }
                }
            }

            return count;
        }

        private void dfs(char[][] grid, int i, int j, int[][] directions, int m, int n)
        {
            //base case
            if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
                return;

            //logic
            grid[i][j] = '0';
            foreach (var dir in directions)
            {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                dfs(grid, nr, nc, directions, m, n);
            }
        }
    }
