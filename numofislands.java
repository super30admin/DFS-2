class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        if(grid == null || grid[0] == null || m == 0 || n == 0)
        {
            return 0;
        }
        int count = 0;
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j <n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    queue.add(new int [] {i,j});
                    grid[i][j] = '0';
                    while(!queue.isEmpty())
                    {
                        int [] temp = queue.remove();
                        for(int[] dir : directions)
                        {
                            int row = dir[0]+temp[0];
                            int col = dir[1]+temp[1];
                            if(row >= 0 && row < m && col >= 0 && col < n)
                            {
                                if(grid[row][col] == '1')
                                {
                                    grid[row][col] = '0';
                                    queue.add(new int []{row,col});
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
