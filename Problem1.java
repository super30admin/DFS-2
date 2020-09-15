Time Complexity: O(mn)
Space Complexity: O(1)
Ran successfully on leetcode?: yes

class Solution {
    int[][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        m = grid.length;
        n = grid[0].length;
        int output = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfsHelper(i, j, grid);
                    output++;
                }
            }
        }
        
        return output;
    }
    
    private void dfsHelper(int row, int column, char[][] grid){
        //base
        
        
        //logic
        grid[row][column] = '2';
        
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = column + dir[1];
            
            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                dfsHelper(r, c, grid);
            }
        }
    }
}
