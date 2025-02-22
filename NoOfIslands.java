class NoOfIslands {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int c=0;
        int dirs[][]= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    c++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty())
                    {
                        int cur[] = q.poll();
                        for(int dir[]: dirs)
                        {
                            int nr=dir[0]+cur[0];
                            int nc=dir[1]+cur[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n&& grid[nr][nc]=='1')
                            {
                                grid[nr][nc]='0';
                                 q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return c;
    }
}
//tc:  O(m * n)
//sc:  O(m * n)