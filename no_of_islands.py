# Explain your approach in three sentences only at top of your code
# The problem is solved using Depth-First Search (DFS) to traverse and mark all connected '1's for each island found. 
# Whenever a '1' is encountered, the DFS marks all connected land cells ('1's) as visited by turning them into '0's. 
# This ensures each island is counted exactly once during traversal.

# Time Complexity : O(m * n), where m is the number of rows and n is the number of columns, as each cell is visited at most once.
# Space Complexity : O(m * n) in the worst case due to the recursion stack for DFS when all cells are land.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # Base case: If the grid is empty, return 0
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])  # Dimensions of the grid
        num_islands = 0  # Counter for islands

        # Helper function to perform DFS
        def dfs(r, c):
            # Boundary and visited check
            if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] == "0":
                return
            
            # Mark the current cell as visited
            grid[r][c] = "0"
            
            # Perform DFS in all four directions
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        
        # Iterate through each cell in the grid
        for r in range(rows):
            for c in range(cols):
                # If the cell is land ('1'), it's a new island
                if grid[r][c] == "1":
                    num_islands += 1  # Increment the island count
                    dfs(r, c)  # Perform DFS to mark the entire island as visited
        
        return num_islands
