using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class Island
    {
        /*
         * T.C: O(m*n) since traversing through all the elements in grid
         * S.C: O(min(m,n)) 
         * 
         */
        public int NumIslands(char[][] grid)
        {
            int m = grid.Length;
            int n = grid[0].Length;

            Queue<int[]> queue = new Queue<int[]>();

            int[,] dirs = new int[,] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

            int count = 0;


            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        queue.Enqueue(new int[] { i, j });
                        grid[i][j] = '0';
                        count++;
                        while (queue.Count != 0)
                        {
                            var curr = queue.Dequeue();
                            for (int k = 0; k < dirs.GetLength(0); k++)
                            {
                                int r = curr[0] + dirs[k, 0];
                                int c = curr[1] + dirs[k, 1];

                                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1')
                                {
                                    queue.Enqueue(new int[] { r, c });
                                    grid[r][c] = '0';
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
