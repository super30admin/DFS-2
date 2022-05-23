// O(m x n) time and space, m rows and n cols

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                if (grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid, r, c, nr, nc);
                }
            }
        }
        
        return numIslands;
    }
    
    private void dfs(char[][] grid, int r, int c, int nr, int nc){
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0'){
            return;
        }
        
        grid[r][c] = '0'; // set all adjacent land pixels to 0 (since attached to the truggered root node)
        dfs(grid, r - 1, c, nr, nc);
        dfs(grid, r + 1, c, nr, nc);
        dfs(grid, r, c - 1, nr, nc);
        dfs(grid, r, c + 1, nr, nc);
    }
}