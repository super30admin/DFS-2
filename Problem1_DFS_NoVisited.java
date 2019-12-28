/**
LeetCode Submitted : YES
Space Complexity : O(M*N)
Time Complexity: O(M*N)

The idea is to call DFS when node = land i.e. 1 and recursively iterate the grid till we reach an island or exhaust all options of the matrix. Also,I have not created a visited array here and changing the original matrix.
**/

class Solution {
    int[][] visited;
    int m;
    int n;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length < 1)
            return 0;
        
        m =  grid.length;
        n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i< m;i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count ++;
                }
                    
            }
        }
        return count;
        
    }
    
    private void dfs(char[][] grid, int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || grid[i][j] == 0)
            return;
        
        grid[i][j] =  0;
        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(grid,row,col);
        }
        
        
    }
}
