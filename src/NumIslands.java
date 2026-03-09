public class NumIslands {
    public int numIslands(char[][] grid){
        //base condition
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0; //to store num of islands
        //iterating rows
        for(int i = 0; i < grid.length; i++){
            //iterating cols
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        //base condition
        if(i<0 || i >= grid.length || j<0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0'; //mark as visited
        //explore all four directions
        dfs(grid, i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}