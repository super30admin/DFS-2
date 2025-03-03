//https://leetcode.com/problems/number-of-islands/solutions/5043649/faster-lesser-2-methods-detailed-approach-bfs-dfs-python-java-c
class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for(int i = 0 ;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1'){
                    numOfIslands++;
                    dfs(grid,i,j);
                }
                    
            }
        }
        return numOfIslands;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}