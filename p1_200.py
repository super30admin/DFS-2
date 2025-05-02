# 200. Number of Islands

# TC : O(M × N), where M is the number of rows and N is the number of columns. We visit each cell exactly once.
# SC : O(M × N) in the worst case when the grid is filled with land cells. This is due to the recursion stack in the DFS.
# Did this code successfully run on Leetcode : Yes

# Approach :
# Iterate through each cell in the grid.
# When we find a land cell ("1") that hasn't been visited:
    # Increment our island counter
    # Use DFS to mark all connected land cells as visited
# After scanning the entire grid, return the island count.

# Line-by-Line Explanation:
    # First, we handle edge cases where the grid is empty.
    # We get the dimensions of the grid for boundary checking.
    # Initialize island_count to keep track of the number of islands found.
    # The dfs function recursively visits all connected land cells and marks them as visited by changing their value to "2".
    # In the main loop, we scan each cell:
        # If we find an unvisited land cell, increment the island counter
        # Use DFS to mark all connected land cells as visited
        # This ensures each island is counted exactly once
    # Finally, return the total count of islands found.

from typing import List, Optional

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # Handle empty grid case
        if not grid or not grid[0]:
            return 0
        
        # Get dimensions of the grid
        rows, cols = len(grid), len(grid[0])
        
        # Counter for the number of islands
        island_count = 0
        
        # DFS function to mark all connected land cells as visited
        def dfs(r, c):
            # Check boundary conditions and if cell is land
            if (r < 0 or c < 0 or r >= rows or c >= cols or 
                grid[r][c] != "1"):
                return
            
            # Mark the current cell as visited by changing it to "2"
            # (could also use a separate visited set, but this is more efficient)
            grid[r][c] = "2"
            
            # Recursively visit all adjacent cells (horizontally and vertically)
            dfs(r + 1, c)  # down
            dfs(r - 1, c)  # up
            dfs(r, c + 1)  # right
            dfs(r, c - 1)  # left
        
        # Scan the entire grid
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    # Found a new island
                    island_count += 1
                    # Mark all connected land cells as visited
                    dfs(r, c)
        
        return island_count
