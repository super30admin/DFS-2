using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity :  O(MN)
    // Space Complexity :O(MN) - minimum on m , n 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class NumberOfIslands
    {
        public int NumIslands(char[][] grid)
        {
            if (grid == null || grid.Length == 0) return 0;
            int m = grid.Length;
            int n = grid[0].Length;
            int[,] dirs = new int[4, 2] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
            Queue<int[]> q = new Queue<int[]>();
            int count = 0;
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        count++;
                        q.Enqueue(new int[] { i, j });
                        grid[i][j] = '2';
                        while (q.Count != 0)
                        {
                            int[] current = q.Dequeue();
                            for (int k = 0; k < dirs.GetLength(0); k++)
                            {
                                int r = current[0] + dirs[k, 0];
                                int c = current[1] + dirs[k, 1];
                                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1')
                                {
                                    q.Enqueue(new int[] { r, c });
                                    grid[r][c] = '2';
                                }
                            }
                        }
                    }
                }
            }

            return count;
        }
    }
}
