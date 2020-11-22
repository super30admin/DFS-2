//time and Space complexity:O(m*n)

class Solution {
        private int count = 0;
        private int row = 0;
        private int col =0;
        private char grid[][];
    
    public int numIslands(char[][] grid) {
        
        if(grid.length==0) return 0;
     
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
            
            for(int i =0; i<row;i++)
            for(int j =0;j<col;j++)
            {
                if(grid[i][j] =='1')
                {
                dfs(i,j);
                count++;
                }
            }
       return count;
    }
    
    public void dfs(int row, int col)
    {
        if(row<0 || col<0 || row>=this.row || col>=this.col || grid[row][col]=='0' ) return;
        grid[row][col]='0'; //Important this keep tracks of already visited
        dfs(row-1,col);
        dfs(row+1,col);
        dfs(row,col-1);
        dfs(row,col+1);
    }
}
