class Solution 
{
    public int numIslands(char[][] grid) 
    {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int count = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        int dirs[][] ={{0,1},{0,-1},{1,0},{-1, 0}};
        
        
        for(int i = 0; i< rows; i++)
        {
            for(int j=0; j< cols; j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    
                    grid[i][j] = '2';
                    queue.add(new int[]{i,j});
                    
                    while(!queue.isEmpty())
                    {
                        int current[] = queue.poll();
                        
                        for(int dir[]: dirs)
                        {
                            int row = current[0] + dir[0];
                            int col = current[1] + dir[1];
                            
                            if(row >=0 && col >=0 && row < rows && col < cols && grid[row][col] == '1')
                            {
                                grid[row][col] = '2';
                                queue.add(new int[]{row, col});
                            }
                        }
                    }
                }
            }
        }
        
        return count;
        
    }
}