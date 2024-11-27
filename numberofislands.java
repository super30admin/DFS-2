// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach: we perfom dfs on the tree to find the number of 1s in the matrix and we change it into 0.we search the 4 directions of that 1.
// after iterating through the whole matrix, we will ahve the number of islands count.

// Your code here along with comments explaining your approach
public class numberofislands {
    int m,n;
    //int count;
    int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int count =0;
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
    public void dfs(char[][]grid,int i, int j)
    {
        if(i<0 || i==m || j<0 || j==n || grid[i][j]!='1') return;
        grid[i][j]=0;
        for(int[] dir:dirs)
        {
            int r=dir[0]+i;
            int c=dir[1]+j;
            dfs(grid,r,c);
        }
    }
}
