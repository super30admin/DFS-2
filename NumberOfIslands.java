// 200.
//time - O(m * n) but i guess its O(m^2 * n^2)(when 1s and 0s at alternate cells)
//space - O(m * n)
class Solution {
    public int numIslands(char[][] grid) {
        //edge
        if(grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        
        int result = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1') //start dfs by joining islands together
                {
                    result += findIslands(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    private int findIslands(char[][] grid, int row, int column) {
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] direction : dirs)
        {
            //go to neighbour and join it if 1 is present and start dfs from there
            int neighbourRow = direction[0] + row;
            int neighbourColumn = direction[1] + column;
            if(neighbourRow >= 0 && neighbourRow < grid.length && neighbourColumn >= 0 && neighbourColumn < grid[0].length) //neighbour within bounds
            {
                if(grid[neighbourRow][neighbourColumn] == '1')
                {
                    grid[neighbourRow][neighbourColumn] = '2';
                    findIslands(grid, neighbourRow, neighbourColumn);
                }
            }
        }
        return 1;
    }
}
