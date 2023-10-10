# TC - O(m * n), where m is the number of rows and n is the number of columns in the grid.
# SC - O(m * n)
class Solution:
    def numIslands(self, grid):
        if not grid or not grid[0]:
            return 0

        self.m, self.n = len(grid), len(grid[0])
        self.dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)

        return count

    def dfs(self, grid, i, j):
        if not (0 <= i < self.m) or not (0 <= j < self.n) or grid[i][j] == '0':
            return

        grid[i][j] = '0'  # Change the cell which had '1' to '0'

        for dr, dc in self.dirs:
            nr, nc = i + dr, j + dc
            self.dfs(grid, nr, nc)