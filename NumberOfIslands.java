// TC: O(m*n)
// SC: O(m*n)

// Approach: DFS: We iterate through the grid, for every 
// 1 found, we call the dfs function and explore it's neighbours. We mark the currently explore element as 0.

// LC- 200. Number of Islands

public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if (grid == null) {
      return -1;
    }

    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count = dfs(i, j, grid, count) + 1;
        }
      }
    }

    return count;
  }

  public int dfs(int i, int j, char[][] grid, int count) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
      return count;
    }

    grid[i][j] = '0';

    dfs(i + 1, j, grid, count);
    dfs(i - 1, j, grid, count);
    dfs(i, j + 1, grid, count);
    dfs(i, j - 1, grid, count);

    return count;
  }
}