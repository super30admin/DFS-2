public class Solution {
    int rows =0;
    int cols =0;
    public static (int, int)[] directions = { (0, 1), (0, -1), (1, 0), (-1, 0) };
    int numofislands =0;
    public int NumIslands(char[][] grid) {
        if(grid==null || grid.Length==0)
        {
            return 0;
        }
        
        rows = grid.Length;
        cols = grid[0].Length;
        Queue<int[]> q = new Queue<int[]>();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]=='1')
                {
                    numofislands++;
                    dfs(grid,i,j);
                }
            }
        }
        
        
    return numofislands;
    }
    
    private void dfs(char[][] grid,int row,int col)
    {
       if(row <0 || col <0 || row >=rows || col >=cols || grid[row][col]!='1')
       {
           return;
       }
        grid[row][col] = '2';
        foreach(var dir in directions)
        {
            int r = row + dir.Item1;
            int c = col + dir.Item2;
            
            dfs(grid,r,c);
        }
    }
    
}
