number of islands solution DFS solution:

//this is a DFS solution, if we find a island mark it as 0 and check its neighbouring land, keep marking all as 0 until there is no land left.
//we found the island once the dfs function returns to root. We keep iterating over the matrix to find the next land. If everything is changed to water, return the count

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }

        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
