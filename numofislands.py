class Solution:
    def numIslands(self, grid):
        self.dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)
        return count

    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or i == self.m or j == self.n or grid[i][j] != '1':
            return

        grid[i][j] = '0'
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j
            self.dfs(grid, r, c)

# TC O(mxn)
# SC O(mxn)