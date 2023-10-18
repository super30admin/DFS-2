class Solution {
    //Time Complexity: O(m*n)  where m is number of rows and n is umber of columns
    // Space Complexity: O(m*n) where m is number of rows and n is umber of columns
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

     private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row == m || col== n || col < 0 || grid[row][col] != '1'){
            return ;
        }
        grid[row][col] = '2';
        for(int[] dir : dirs ){
            int neighbour_row = row + dir[0];
            int neighbour_col = col + dir[1];
            dfs(grid, neighbour_row, neighbour_col);
        }
    }

}
