/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Idea:
 * 
 * Use dfs, dfsVisit visites all the nodes in the connected component, and the
 * total number of calls to dfsVisit is equal to the number of islands.
 * 
 * Space Complexity: O(m*n) 
 * Time Complexity: O(m*n)
 * 
 * Leetcode Results:
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Islands.
 * Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Number of Islands.
 *
 */
class Solution {

    int[] dr = new int[] { -1, 0, 1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public int numIslands(char[][] grid) {
        // base cases
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // dimensions of matrix
        int nRows = grid.length, nCols = grid[0].length;
        // DFS approach, each call to DFS-VISIT covers one Island.
        int nIslands = 0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                // if it is part of island, we want to visit it.
                // Also, increment count.
                if (grid[row][col] == '1') {
                    dfsVisit(grid, nRows, nCols, row, col);
                    nIslands++;
                }
            }
        }

        return nIslands;
    }

    private void dfsVisit(char[][] grid, int nRows, int nCols, int row, int col) {
        // check for out of bounds
        if (row < 0 || col < 0 || row >= nRows || col >= nCols) {
            return;
        }
        // this should be part of Island, else return
        if (grid[row][col] != '1') {
            return;
        }

        // mark visited, changing symbol would work for this example
        grid[row][col] = '2';

        // let's try to visit its 4 neighbors.
        for (int i = 0; i < 4; i++) {
            dfsVisit(grid, nRows, nCols, row + dr[i], col + dc[i]);
        }
    }
}
