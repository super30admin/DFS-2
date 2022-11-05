// Approach: DFS, trigger dfs from the first cell that is land and mark all the connected cells in this island as water, so that we dont visit these again. Now continue traversing the grid and see if we find more islands.
// Time Complexity: O(mn)
// Space Complexity: O(mn)

public class Solution {
    char[][] grid;
    int rows, cols, res;
    public int NumIslands(char[][] grid) {
        this.grid = grid;
        rows = grid.Length;
        cols = grid[0].Length;
        
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(i, j);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int i, int j){
        if(i>= rows || j>=cols || i< 0 || j<0 || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        dfs(i+1, j);
        dfs(i, j+1);
        dfs(i-1, j);
        dfs(i, j-1);
    }
}