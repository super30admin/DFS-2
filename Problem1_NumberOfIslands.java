// Time Complexity : o(mn)
// Space Complexity : o(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
   /*
    int[][] dirs;
    //using dfs
    public int numIslands(char[][] grid) {
       
        if(grid.length==0 || grid==null)
            return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        int isIslandCount=0;
       dirs=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    isIslandCount++;
                    dfs(grid,i,j,m,n);
                }
                    
            }
        }
        return isIslandCount;
    }
    */
    
    /*
    private void dfs(char[][] grid,int r,int c,int m,int n)
    {
        
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]=='0')
            return;
        
        grid[r][c]='0';
       
       // int[][] dirs=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        for(int[] dir: dirs)
        {
            int nR=dir[0]+r;
            int nC=dir[1]+c;
            
           dfs(grid,nR,nC,m,n);
        }
    }
    */
    
    int[][] dirs;
    //using bfs
    public int numIslands(char[][] grid) {
       
        if(grid.length==0 || grid==null)
            return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        int isIslandCount=0;
        Queue<int[]> queue=new LinkedList<>();
        
       dirs=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    isIslandCount++;
                     queue.add(new int[]{i,j});
                      grid[i][j]='0';
                    while(!queue.isEmpty())
                    {
                        int[] curr=queue.poll();
                        
                        for(int[] dir:dirs)
                        {
                            int nR=dir[0]+curr[0];
                            int nC=dir[1]+curr[1];
                            
                            if(nR>=0 && nR<m && nC>=0 && nC<n && grid[nR][nC]=='1')
                            {
                                grid[nR][nC]='0';
                                queue.add(new int[]{nR,nC});
                            }
                        }
                    }
                }
                    
            }
        }
        return isIslandCount;
    }
}
