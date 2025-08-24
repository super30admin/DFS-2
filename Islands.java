// This solution uses a DFS approach to mark the islands as clusters. We iterate through all the indices and whenever we encounter a '1' we increment the island count and mark all the adjacent 1's as 2's to keep a track of visited. 
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    islands++;
                    markIsland(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void markIsland(char[][] grid, int i, int j) {
        grid[i][j]='2';
        for(int[] dir:dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if((row>=0 && row<grid.length) && (col>=0 && col<grid[0].length) && (grid[row][col]=='1')) {
                 markIsland(grid, row, col);
            }
        }
    }
}
