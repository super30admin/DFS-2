//Time Complexity: O(mn).. Since we are travesing each cell of the matrix
// Space Complexity: O(mn).. Recusrive call stack
//Leetcode: 200. Number of Islands
// Using DFS
class Solution {
    int[][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {
        m=grid.length; n=grid[0].length;
        dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int islandCount=0;
        for(int i=0;i< m; i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j, grid);
                    islandCount++;
                }
                    
            }
        }
        
        return islandCount;
    }
    
    public void dfs( int i, int j, char[][] grid)
    {
       
        //base
        if(grid[i][j]=='0')
        {
            return;
        }
        else
        {
            grid[i][j]='0';
             //logic
            int r,c;
            for(int[] dir: dirs)
            {
                r=dir[0]+i;
                c=dir[1]+j;
                if(r< m && c<n && r>=0 && c>=0 && grid[r][c]=='1')
                {
                    dfs(r, c, grid);
                }
            }
        }
        
       
    }
}