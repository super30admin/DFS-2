/**

Leetcode: https://leetcode.com/problems/number-of-islands/

Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Procedure:
1. Traverse the matrix to find the location of all the 1's in the matrix, add that pair in the queue

2. Check the neighbours of the cell and keep on setting to 0, once all its neighbours are set to 0, this will be treated 


Collabedit: http://collabedit.com/ux9gt
**/

class Solution 
{
    public int numIslands(char[][] grid) 
    {
        if( grid == null || grid.length == 0) return 0;
        
        int rowCount = grid.length;
        int colCount = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        
        int islands = 0;
        
        int directions[][] = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        
        for( int i =0 ;i < rowCount; i++)
        {
            for( int j =0 ;j < colCount; j++)
            {
                if( grid[i][j] == '1')
                {
                    queue.add( new Pair(i, j));
                    grid[i][j] = '0';
                    islands++;
                    
                    while( !queue.isEmpty() )
                    {
                            Pair current = queue.poll();
                
                            for( int dir[]: directions)
                            {
                                int row = current.rowIndex + dir[0];
                                int col = current.colIndex + dir[1];
                    
                                if( row >=0 && row < rowCount && col >=0 && col < colCount && grid[row][col] == '1')
                                {
                                    grid[row][col] = '0';
                                    queue.add( new Pair(row, col));
                                }
                            }

                    }
                }
            }        
        }
        
        
        return islands;
        
    }
}
class Pair
{
    public int rowIndex;
    public int colIndex;
    
    public Pair( int row, int col)
    {
        this.rowIndex = row;
        this.colIndex = col;
    }
}