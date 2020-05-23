package com.ds.rani.dfs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */

//Approach: visit one cell and check its neigbours ,then its neibhours and so on.
//Time complexity:o(rows*cols)
//space complexity:o(1)

public class NumbOfIsland {
    public int numIslands(char[][] grid) {

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                //if current cell is a land then visit its neigbour nodes by calling DFS
                if (grid[row][col] == '1') {
                    dfs( grid, row, col );
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int row, int col) {
        //right,bottom, top,left
        int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        //if the current cell satisfy all the conditions then visit its neigbours and chenge its value as 0
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {

            for (int[] dir : dirs) {
                int r = dir[0] + row;
                int c = dir[1] + col;

                grid[row][col] = '0';
                dfs( grid, r, c );
            }
        }


    }
}
