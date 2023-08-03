// Time Complexity :O(2(mxn))
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

// Here we need to consider all the 1s which are connected as an island. To do that, we will have a count variable, 
//and whenever we encounter a 1, we will increment the count by 1, and make the encountered and all its connected 1s also 0. 

class Solution {
    public int numIslands(char[][] grid) {
           int m=grid.length;
           int n=grid[0].length;
           int count=0;
           int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
           Queue<int []>q=new LinkedList<>();

           for(int i=0;i<m;i++)
           {
               for(int j=0;j<n;j++)
               {
                   if(grid[i][j]=='1')
                   {
                       count++;
                       q.add(new int[]{i,j});
                       grid[i][j]='0';

                       while(!q.isEmpty())
                       {
                           int[] curr=q.poll(); //pop the value in the queue and store it in the curr variable
                           for(int[] dir:dirs) //check if the neighboring elements are also 1
                           {
                               int nr=curr[0]+dir[0];
                               int nc=curr[1]+dir[1];
                               if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1')// if the neighboring elements are 1, then make them 0
                           {
                               q.add(new int[] {nr,nc});
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

// DFS: When we encounter a 1 in the matrix we will get into a recursive function, where we check if all the neighboring elements are also 1. If they are, then we make them 0 and if they are not we get out of the recursion. 

class Solution {
    int [][] dirs;
    int m,n;
    public int numIslands(char[][] grid) {
            m=grid.length;
            n=grid[0].length;
           int count=0;
           this.dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

           for(int i=0;i<m;i++)
           {
               for(int j=0;j<n;j++)
               {
                   if(grid[i][j]=='1')
                   {
                       count++;
                       dfs(grid,i,j);
                   }
               }

           }
        return count;   
        
    }

    private void dfs(char [][] grid,int i, int j)
    {
        //base
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0') return;
        //logic
        grid[i][j]='0'; //We change the cell which had 1 to 0
        for(int [] dir: dirs)
        {
            int nr=dir[0]+i;
            int nc=dir[1]+j;

            dfs(grid,nr,nc);
        }
    }
}
