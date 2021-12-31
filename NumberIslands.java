// Time Complexity : O(mn)
// Space Complexity : O(mn)
// BFS
public class NumberIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null)
            return count;
        
        int m = grid.length, n = grid[0].length;
        int dirs[][] = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                if(grid[i][j] == '1')
                {
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty())
                    {
                        int [] curr = q.poll();
                        for(int dir[]: dirs)
                        {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1')
                            {
                               grid[nr][nc] = '0';
                                q.offer(new int []{nr, nc});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}


// Time Complexity : O(mn)
// Space Complexity : O(mn)
// DFS
public class NumberIslands {
    int dirs[][];
    int m,n;
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null)
            return count;
        
        m = grid.length;
        n = grid[0].length;
        dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j ++)
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

    private void dfs(char[][] grid, int i, int j)
    {
        // base
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
        {
             return;
         }
        
        // recursive
        grid[i][j] = '0';
        for(int dir[]: dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc);
        }
    }
}
