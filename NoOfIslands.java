//Time Complexity-O(n*m)
//Time Complexity=O(n*m) because we are using recursive stack
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        if(grid.length==0|| grid==null|| grid[0].length==0)
        {
            return count;
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    recur(grid,i,j);
                }
            }
        }
        return count;
        
    }
    
    int[][]directions={{1,0},{0,1},{-1,0},{0,-1}};
    
    private void recur(char[][] grid,int i,int j)
    {
        grid[i][j]='0';
        for(int[]dirs:directions)
        {
            int row=i+dirs[0];
            int col=j+dirs[1];
            if(row>=0 && row<grid.length&& col>=0 && col<grid[0].length &&(grid[row]                          [col]=='1'))
            {
                recur(grid,row,col);
            }
        }
    }
}