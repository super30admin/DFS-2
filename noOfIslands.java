class Solution {
    //Time complexity: O(mn)
    //Space complexity: O(mn)
    int[][] dirs=new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        m=grid.length;
        int c=0;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    c++;
                dfs(grid,i,j,m,n);
                }
            }
        }
        return c;
    }
    private void dfs(char[][] grid,int i,int j,int m,int n){
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        for(int[] dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            dfs(grid,r,c,m,n);
        }
    }
}