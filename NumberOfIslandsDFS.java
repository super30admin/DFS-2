package DFS2;
// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes

public class NumberOfIslandsDFS {
    int [][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid){
        if(r < 0 || r >= grid.length || c <0 || c >= grid[0].length || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for(int [] dir : dirs){
            int row = r + dir[0];
            int col = c + dir[1];
            dfs(row, col, grid);
        }
    }
}
