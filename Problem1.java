//DFS
//time o(mn) m - no of rows, n - no of cols
//space o(mn)
class Solution {
    int[][] dirs ={{1,0},{0,1},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int res=0;
        if(grid==null || grid.length==0)
            return res;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][]grid, int i, int j){
        //base case
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0')
            return;
        //logic
        grid[i][j]= '0';
        for(int[] dir: dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid,r,c);
        }
    }
}