//time complexity:O(m x n)
//space complexity:O(m x n)
class Solution {
    int count;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dirs= new int[][] {{0,-1},{0,1},{1,0},{-1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;//if the element is 1 increment the 
                    //count
                    dfs(grid,i,j,m,n);//recirsive call
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r,int c, int m, int n)
    {
        if(r<0||c<0||r==m||c==n||grid[r][c]!='1') return;
        grid[r][c]='0';//replace 1 by 0
        
        for(int [] dir:dirs)
        {
            //check the neighbours 
            int nr=dir[0]+r;
            int nc=dir[1]+c;
            dfs(grid,nr,nc,m,n);//again recursive call 
            
        }
    }
}
