/**
TC - O(m*n)
SC - O(1)

**/
class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int noOfIslands = 0;
        int dirs[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                
                if (grid[i][j] == '0' || grid[i][j] == 'a')
                {
                    continue;
                }
                
                if (grid[i][j] == '1')
                {   
                    // BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    grid[i][j] = 'a';
                    
                    while (!queue.isEmpty())
                    {
                        int remove[] = queue.remove();
                        
                        for (int dir[] : dirs)
                        {
                            int ni = remove[0] + dir[0];
                            int nj = remove[1] + dir[1];
                            
                            if (ni>=0 && ni<rows && nj>=0 && nj<cols && grid[ni][nj] == '1')
                            {
                                grid[ni][nj] = 'a';
                                queue.add(new int[]{ni, nj});
                            }
                        }
                    }
                    
                    noOfIslands += 1;
                }
            }
        }
        
        return noOfIslands;
    }
}
