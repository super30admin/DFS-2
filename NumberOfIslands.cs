//BFS,DFS - Time complexity - O(mn)
//BFS, DFS- space complexity - O(mn)
public class Solution
{
    public int NumIslands(char[][] grid)
    {

        if (grid == null)
        {
            return 0;
        }

        Queue<int[]> bfs = new Queue<int[]>();
        int res = 0;
        int[][] dir = { [0, 1], [0, -1], [1, 0], [-1, 0] };
        // DFS
        for (int i = 0; i < grid.Length; i++)
        {
            for (int j = 0; j < grid[0].Length; j++)
            {
                if (grid[i][j] == '1')
                {
                    res++;
                    dfs(grid, dir, i, j);
                }
            }
        }
        return res;
        //BFS
        //         if(grid[i][j] == '1')
        //         {
        //             bfs.Enqueue([i,j]);
        //             grid[i][j] = '0';
        //             res++;
        //         }
        //         while(bfs.Count>0)
        //         {
        //             int [] bfsVal = bfs.Dequeue();
        //             foreach(int[] d in dir)
        //             {       
        //                 int r = bfsVal[0]+ d[0]; 
        //                 int c = bfsVal[1]+ d[1];
        //                 if(r >= 0 && c >= 0 && r < grid.Length && c < grid[0].Length && grid[r][c] == '1')
        //                 {
        //                     grid[r][c] = '0';
        //                     bfs.Enqueue([r,c]);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return res;
    }
    private void dfs(char[][] grid, int[][] dir, int r, int c)
    {
        // base
        if (r < 0 || c < 0 || r == grid.Length || c == grid[0].Length || grid[r][c] == '0')
        {
            return;
        }
        // logic
        foreach (int[] d in dir)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            grid[r][c] = '0';
            dfs(grid, dir, nr, nc);
        }
    }
}