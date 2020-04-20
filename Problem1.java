// Time Complexity - O(m*n)
// Space Complexity - O(1) - Without recursive stack
//                  - O(maxdepth) - With recursive stack

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0 ){
            return 0;
        }
        int m= grid.length;
        int n= grid[0].length;

        int noOfIsland=0;
        for(int i=0; i<m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j]=='1'){
                    noOfIsland++;
                    dfs(i,j, grid);
                }
            }
        }
        return noOfIsland;
    }

    private void dfs(int i,int j, char[][] grid){

        if(i <0 || i>=grid.length || j<0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1, grid);
        dfs(i,j-1,grid);
    }
}