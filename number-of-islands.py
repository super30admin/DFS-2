# The code uses Depth-First Search (DFS) to explore and mark all connected land cells ('1') starting from each unvisited land cell, 
# counting the number of distinct islands in the grid. Each island is marked with '#' to avoid revisiting cells.

# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns. Every cell is visited once during the DFS.
# Space Complexity: O(m * n) in the worst case, due to the recursion stack for DFS when the entire grid is land.
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count
    
    def dfs(self, grid, i, j):
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != '1':
            return
        grid[i][j] = '#'
        self.dfs(grid, i+1, j)
        self.dfs(grid, i, j+1)
        self.dfs(grid, i-1, j)
        self.dfs(grid, i, j-1)
        