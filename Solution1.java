// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I iterate through each element of the grid and call the dfs fn when any element = '1' and increment the counter on the basis of the 
 * number of times dfs fn is called. In the dfs fn, I set the element = '0' call dfs on all neighbouring elements and repeat the same process.
 */

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j,grid,rows,columns);
                    count+=1;
                }
                
            }
        }
        return count;
    }

    public void dfs(int i,int j,char [][]grid,int rows,int columns)
    {
        if(i<0 || i>=rows || j<0 || j>=columns || grid[i][j]!='1')
        {
            return;
        }
        grid[i][j]='0';
        dfs(i+1,j,grid,rows,columns);
        dfs(i-1,j,grid,rows,columns);
        dfs(i,j+1,grid,rows,columns);
        dfs(i,j-1,grid,rows,columns);
    }
}