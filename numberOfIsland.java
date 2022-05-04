//TC : O(mxn) SC : O(Max(m,n))
class Solution {
    int[][] dirs;
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int count =0;
        m=grid.length;
        n = grid[0].length;
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == '1')
                {
                    grid[i][j] = '0';
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid,int r,int c)
    {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r,c});


        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1')
                {
                    grid[nr][nc] = '0';
                    q.add(new int[] {nr,nc});
                }
            }
        }

    }
}