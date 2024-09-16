class Solution {
    int m=0;
    int n=0;
    
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        m=grid.length;
        n=grid[0].length;
        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty())
                    {
                        int[] index=q.poll();
                        for(int[] dir:dirs)
                        {
                            int r=index[0]+dir[0];
                            int c=index[1]+dir[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1')
                            {
                                grid[r][c]='0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

// Time Complexity: O(m*n*m)
// Space Complexity: O(m*n)