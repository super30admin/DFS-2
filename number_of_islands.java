//Time Complexity : O(r*c)
//Space Complexity: O(r*c)
class Solution {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int count = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][]grid, int i, int j)
    {
        //base
        if(i<0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j]=='0')
            return;
        
        //logic
        for(int[] dir: dirs)
        {
            grid[i][j] = '0';
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }
}