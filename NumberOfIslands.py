# Time Complexity: O(M * N), M * N is the size of the grid
# Space Complexity: O(M * N)
# Did this code successfully run on Leetcode: Yes

from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        for row in range(m):
            for col in range(n):
                if grid[row][col] == "1":
                    self.dfs(grid, row, col, m, n, directions)
                    count += 1
        
        return count

    def dfs(self, grid, row, col, m, n, directions):
        if row < 0 or col < 0 or row >= m or col >= n or grid[row][col] != "1":
            return

        grid[row][col] = "0"
        for dir in directions:
            new_row = dir[0] + row
            new_col = dir[1] + col
            self.dfs(grid, new_row, new_col, m, n, directions)
        
        