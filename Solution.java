//No of islands
//TC:O(m*n)
//SC:O(m*n)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        
       this.m=grid.length;
        this.n=grid[0].length;

        this.dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int count=0;
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
    private void dfs(char[][] grid,int i,int j)
    {
        //base case
        //edge case for columns and when grid[i][j] is zero,then move to next cell
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0')
        {
            return;
        }


        //logic

        grid[i][j]='0';
        for(int[] dir:dirs)
        {
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            dfs(grid,nr,nc);
        }
    }

}