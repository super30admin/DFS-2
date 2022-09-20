class Solution {
    //tc = o(m*n)
    //sc=o(m*n)
    int m;         
    int n; 
    int[][] dirs; 
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0) return 0;
        
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int count =0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
        
    }
    private void dfs(char[][]grid,int i,int j)
    {
        //base case
        if(i<0 || j <0 || i == m || j ==n || grid[i][j] == '0') return;
        
        //logic
        grid[i][j] = '0';
        for(int[] dir : dirs)
        {
            int nr = i+dir[0];
            int nc = j+dir[1]; 
            dfs(grid,nr,nc);
        }
       
        
    }
}