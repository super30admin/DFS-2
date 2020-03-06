//Time Complexity: O(n) n = M*N
//Space Complexity: O(n) n = M*N
//LeetCode : Yes 
//Make all the neighbours of the visited nodes to unvisited. 

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0; j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public int dfs(char[][] grid, int i, int j){
        if(grid[i][j] == '0' || i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        
        grid[i][j] = '0';
        
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i, j+1);
        dfs(grid, i , j-1);
        return 1;
    }
}
