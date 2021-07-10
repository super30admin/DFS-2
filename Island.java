// Time Complexity :O(nm)
// Space Complexity :O(nm)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        //edge case
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i <n;i++)
        {
            for(int j = 0 ; j <m ; j ++)
            {
                if(grid[i][j]=='1')
                {
                    //dfs
                    recur(grid,n,m,i,j);
                    count+=1;
                    
                }
            }
        }
        return count;
    }
    int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private void recur(char[][] grid,int n, int m, int i ,int j)
    {
        grid[i][j] = '0';
        for(int [] d:dirs)
        {
            int r = i+d[0];
            int c= j+d[1];
            if(r>=0 && r <n && c>=0 && c <m && grid[r][c] =='1')
            {
                recur(grid,n,m,r,c);
            }
        }
    }
}