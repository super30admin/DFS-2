// Time Complexity : O(m * n), m - rows, n - columns
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Do DFS if cell value is 1, increment islandCount
// 2. In DFS, explore all the 4 neighbors and update visited lands to 0

public class Islands {
    static int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};

    public static int numIslands(char[][] grid) {

        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

     static void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == '0') {
            return;
        }

        // mark as visited
        grid[r][c] = '0';

        // explore all directions
        for(int[] dir : dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;

            dfs(grid, row, col);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}
        };
        System.out.println(numIslands(grid));
    }
}
