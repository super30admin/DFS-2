// Time Complexity : O(m * n), where 'm' is the number of rows and 'n' is the number of columns in the grid. In the worst case, we may have to traverse the entire grid.
// Space Complexity :O(m * n), where 'm' is the number of rows and 'n' is the number of columns in the grid. In the worst case, we may have to traverse the entire grid.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: The main idea is to perform Depth-First Search(DFS)on the 2D binary grid.We iterate through each cell in the grid, and if the cell contains a '1', we start the DFS from that cell to explore and mark all connected '1's as visited.
// During the DFS, we update the '1's to '0's to mark them as visited. We use recursion to traverse all the neighboring cells (top, bottom, left, and right) from a given cell. The number of times we start the DFS will give us the count of islands.

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return;
        }

        // Mark the cell as visited
        grid[row][col] = '0';

        // Explore the neighboring cells
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        int islands = solution.numIslands(grid);
        System.out.println("Number of islands: " + islands);
    }
}
