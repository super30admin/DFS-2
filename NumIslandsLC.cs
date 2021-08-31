public class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int NumIslands(char[][] grid) {
       if (grid == null || grid.Length == 0)
            {
                return 0;
            }
            int cnt = 0;
            //BFS
            Queue<int[]> q = new Queue<int[]>();
            int m = grid.Length;
            int n = grid[0].Length;
            int[][] dirs = new int[4][] { new int[2] { 0, 1 }, new int[2] { 0, -1 }, new int[2] { 1, 0 }, new int[2] { -1, 0 } };
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        cnt++;
                        grid[i][j] = '0';
                        q.Enqueue(new int[] { i, j });
                        while (q.Count != 0)
                        {
                            int size = q.Count;//works without for loop using size
                            for (int k = 0; k < size; k++)
                            {
                                int[] curr = q.Dequeue();
                                foreach (int[] dir in dirs)
                                {
                                    int r = curr[0] + dir[0];
                                    int c = curr[1] + dir[1];
                                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1')
                                    {
                                        q.Enqueue(new int[] { r, c });
                                        grid[r][c] = '0';
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return cnt;  
    }
}