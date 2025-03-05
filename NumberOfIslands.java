// Approach: Traverse the grid cell by cell. When a 1 is encountered, perform a DFS from that cell, exploring all four neighbors (up,
// down, left, right) while marking visited cells as 0 to prevent revisiting. Keep track of the number of top-level DFS calls (excluding
// recursive calls), as each represents a distinct cluster of 1s, effectively counting the number of islands in the grid.
// Time Complexity: O(m * n) where m - #rows, n - #cols
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/number-of-islands/description/

public class NumberOfIslands {

    int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    DFS(grid, i, j);
                }
            }
        }
        return cnt;
    }

    void DFS(char[][] grid, int row, int col) {
        if (!isSafe(grid, row, col)) {
            return;
        }
        grid[row][col] = 0;

        int[] rowN = { -1, 0, 1, 0 };
        int[] colN = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nr = row + rowN[i], nc = col + colN[i];
            if (isSafe(grid, nr, nc) && grid[nr][nc] == '1') {
                DFS(grid, nr, nc);
            }
        }
    }

    boolean isSafe(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        // Input: grid = [
        //  ["1","1","0","0","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","1","0","0"],
        //  ["0","0","0","1","1"]
        // ]
        // Output: 3

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println("Number of Islands in the given grid are: " + noi.numIslands(grid));
    }
}