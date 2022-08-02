// dfs
//o(m*n) Space and time complexity
/*class Solution {
    int m,n;
    int total;
    int [][] dirs;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    total++;
                    dfs(i,j,grid);
                }
            }
        }
return total;

    }
    private void dfs(int row, int col,char[][] grid)
    {
        if(row<0 || col<0 || row==m || col==n || grid[row][col]!='1')
        {
           return;
         }
    grid[row][col]=0;
    for(int []dir:dirs)
    {
        int nr=dir[0]+row;
        int nc=dir[1]+col;
        dfs(nr,nc,grid);
    }
}
}*/
// bfs solution
class Solution {
    int m,n;
    int total;
    int [][] dirs;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    total++;
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j]='0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty())
                    {
                        int []curr=q.poll();
                        for(int[] dir:dirs)
                        {
                            int nr=dir[0]+curr[0];
                            int nc=dir[1]+curr[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1')
                            {
                                q.add(new int[]{nr,nc});
                                grid[nr][nc]='0';

                            }
                        }
                    }
                }
            }
        }
        return total;
    }
}



