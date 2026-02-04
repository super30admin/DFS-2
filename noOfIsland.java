class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int island = 0;

     for(int i =0; i< grid.length; i++){
        for(int j =0; j< grid[0].length; j++){
            if(grid[i][j] == '1'){
                dfs(i,j, grid);
                island++;
            }
        }
     }
    return island;   
    }

    private void dfs(int i, int j, char[][] grid){
        
        grid[i][j] = '0';

        for(int[] dir : dirs){
            int newR = dir[0] + i;
            int newC = dir[1] + j;

            if(newR >=0 && newC >= 0 && newR < grid.length && newC < grid[0].length && grid[newR][newC] == '1')
                dfs(newR, newC, grid);
        }

    }
}