// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Method used : DFS

class Solution {

    int[][] visited;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        
        int rows = grid.length, cols = grid[0].length;
        visited = new int[rows][cols];
        int count = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(visited[i][j] == 0 && grid[i][j] == '1')
                {
                    helper(i, j, grid, rows, cols);
                    ++count;
                }
            }
        }

        return count;
    }

    private void helper(int row, int col, char[][] grid, int rows, int cols)
    {
        if(row < 0 || row == rows || col < 0 || col == cols || visited[row][col] != 0 || grid[row][col] == '0') return;

        visited[row][col] = 1;

        for(int[] dir : dirs)
        {
            int new_row = row + dir[0];
            int new_col = col + dir[1];
            
            helper(new_row, new_col, grid, rows, cols);
        }
    }
}