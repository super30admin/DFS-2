//****NUMBER OF ISLAND-  DFS APPROACH****
// Time Complexity : O(m*n);
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

class Solution {
    int [][] dirs;
    int m;
    int n; 
    public int numIslands(char[][] grid) 
    {
        //Boiler plate code for going in 4 different directions
        m=grid.length;
        n=grid[0].length;  
        
        //Directions array      //u     //D  //L    //R
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        int count=0;
        //Iterate through given matrix
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
     return count;   
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n)
    {
        //Base
        if(i==m || j==n || i<0 || j<0 || grid[i][j]=='0')
        {
            return;
        }
        
        //Logic
        grid[i][j]='0';
        //Check if there is 1 in its other 4 directions
        for(int[] dir: dirs)
        {
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            
            dfs(grid,nr,nc,m,n);
        }
    }
}

//****NUMBER OF ISLAND-  BFS APPROACH****
// Time Complexity : O(m*n);
// Space Complexity :MIN(m*n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N
// Your code here along with comments explaining your approach

class Solution {
    int [][] dirs;
    int m;
    int n; 
    public int numIslands(char[][] grid) 
    {
        //Boiler plate code for going in 4 different directions
        m=grid.length;
        n=grid[0].length;  
        
        //Directions array      //u     //D  //L    //R
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        int count=0;
        //Declaring 2 different queues
        Queue<Integer> rq=new LinkedList<>();
        Queue<Integer> cq=new LinkedList<>();
        
        //Iterate through given matrix
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    rq.add(i);
                    cq.add(j);
                    grid[i][j]='0';
                    //Processing the queue
                    while(!rq.isEmpty())
                    {
                        int cr=rq.poll();
                        int cc=cq.poll();
                        
                        for(int[] dir: dirs)
                        {
                            int nr=cr+dir[0];
                            int nc=cc+dir[1];
                            //Bound check
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1')
                            {
                                rq.add(nr);
                                cq.add(nc);
                                grid[nr][nc]='0';
                            }
                        }
                        
                    }
                    
                }
            }
        }
     return count;   
    }
    
    
}
