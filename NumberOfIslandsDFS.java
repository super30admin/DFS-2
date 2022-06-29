class Solution 
{
    
    private int dirs[][] ={{0,1},{0,-1},{1,0},{-1, 0}};
    
    public int numIslands(char[][] grid) 
    {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        
        
        for(int i = 0; i< rows; i++)
        {
            for(int j=0; j< cols; j++)
            {
                if(grid[i][j] == '1')
                {
                    result++;
                    dfs(grid, i, j, rows, cols);
                }
            }       
        }
        
        return result;
        
    }

    private void dfs(char[][] grid, int i, int j, int M, int N)
    {
        if(i >= 0 && i < M && j >=0 && j < N && grid[i][j] == '1')
        {
            grid[i][j] = '2';
            
            for(int dir[]: dirs)
            {
                int row = i + dir[0];
                int col = j + dir[1];
                dfs(grid, row, col, M, N);
            }
        }
    }
    
    
}