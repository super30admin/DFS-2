public class Solution {
    int[][] dirs;
    int rows;
    int columns;
    public int NumIslands(char[][] grid) {
        dirs = new int[][]{
        new int[]{-1,0},
        new int[]{0,-1},
        new int[]{1,0},
        new int[]{0,1}
    };
    rows = grid.Length;
    columns = grid[0].Length;
    int noOfIslands = 0;
    for(var i=0;i<rows;i++)
    {
        for(var j=0;j<columns;j++)
        {
            if(grid[i][j]=='1')
            {
            noOfIslands++;
            grid[i][j]='0';
            dfs(grid,i,j);
            }
        }
    }
    
    return noOfIslands;
    }
    void dfs(char[][] grid,int i,int j)
    {
        foreach(var dir in dirs)
        {
            int r = dir[0]+i;
            int c = dir[1]+j;
            if(r>=0 && c>=0 && r<rows && c<columns && grid[r][c] == '1')
            {
                grid[r][c]='0';
                dfs(grid,r,c);
            }

        }
    }
}