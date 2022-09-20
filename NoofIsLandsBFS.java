class Solution {
    //tc = o(m*n)
    //sc=o(m*n)
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int count =0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    q1.add(i);
                    q2.add(j);
                    grid[i][j] = '0';
                    count++;
                    
                    //bfs
                    while(!q1.isEmpty())
                    {
                       int cr = q1.poll();
                       int cc = q2.poll();
                        
                        for(int[] dir : dirs)
                        {
                            int nr = dir[0] + cr;
                            int nc = dir[1] + cc;
                            //boundary conditions
                            if(nr >= 0 && nc >=0 && nr <m && nc < n && grid[nr][nc] == '1')
                            {
                                q1.add(nr);
                                q2.add(nc);
                                
                                grid[nr][nc] = '0';
                                
                            }
                            
                        }
                    }
                    
                }
            }
        }
        
        return count;
        
    }
}