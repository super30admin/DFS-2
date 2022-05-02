/*
DFS Solution
time - O(m*n)
space - O(m*n)
*/
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int numOfIslands = 0;
        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, grid);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    private void dfs(int r, int c, char[][] grid){
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1')
            grid[r][c] = '0';
        else return;

        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);
    }
}