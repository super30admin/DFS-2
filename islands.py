# The numIslands method counts the number of islands in a 2D grid.
# An island is a group of '1's (land) connected horizontally or vertically.

# Step 1: Initialization
#   - Get the grid dimensions (rows, cols).
#   - Initialize 'islands' to count the number of islands.

# Step 2: DFS Helper
#   - Recursively mark connected '1's as '0' (visited).
#   - Stop if the cell is out of bounds or not land ('1').

# Step 3: Main Loop
#   - For each cell in the grid:
#       - If the cell is '1', start DFS to mark the entire island and increment 'islands'.

# TC: O(m * n) - Each cell is visited once.
# SC: O(m * n) - Space for recursion stack in the worst case.


from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        islands = 0
        
        def dfs(row, col):
            if row < 0 or row >= rows or col < 0 or col >= cols or grid[row][col] != '1':
                return
            grid[row][col] = '0'  # Mark current cell as visited
            
            # Recursively visit all four possible directions
            dfs(row - 1, col)  # Up
            dfs(row + 1, col)  # Down
            dfs(row, col - 1)  # Left
            dfs(row, col + 1)  # Right
        
        # Traverse each cell in the grid
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    # Found a new island, initiate DFS to mark all connected land cells
                    dfs(row, col)
                    islands += 1
        
        return islands