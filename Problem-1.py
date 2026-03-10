# Time Complexity : O(m * n)  # m = rows, n = columns
# Space Complexity : O(m * n)  # recursion stack in worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# The code counts the number of islands in a grid of '1's (land) and '0's (water).
# It iterates over the grid, and for each unvisited '1', it starts a DFS to mark all connected land as visited.
# Each DFS explores one island completely, so the number of DFS calls equals the number of islands.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])
        visited = [[False]*m for _ in range(n)]
        islands = 0

        for r in range(n):
            for c in range(m):
                if grid[r][c] == "1" and not visited[r][c]:
                    islands += 1
                    self.dfs(r, c, grid, visited)
        
        return islands

    def dfs(self, r, c, grid, visited):
        if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]):
            return
        if grid[r][c] != "1" or visited[r][c]:
            return
        
        visited[r][c] = True
        
        self.dfs(r+1, c, grid, visited)
        self.dfs(r-1, c, grid, visited)
        self.dfs(r, c+1, grid, visited)
        self.dfs(r, c-1, grid, visited)