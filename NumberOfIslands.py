# Time complexity: O(m*n)
# Space complexity: O(m*n)

class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        islands = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j)
                    islands += 1
        return islands

    def dfs(self, grid, r, c):
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] != "1":
            return
        grid[r][c] = "0"
        for dx, dy in [(0, 1), (-1, 0), (0, -1), (1, 0)]:
            self.dfs(grid, r+dx, c+dy)
