//DFS
//Space Complexity: O(n)
//Time Complexity:O(n)
class Solution {
    int m,n ;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                   count++;
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i,int j){
        if(i==m || j==n || i<0 || j<0 || grid[i][j]!='1' ) return;
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        grid[i][j]='0';
        for(int[] dir:dirs){
            int row = dir[0] +i;
            int col = dir[1]+ j;
            dfs(grid,row,col);
        }
    }
}