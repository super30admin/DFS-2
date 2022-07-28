class Solution:
    m = 0
    n = 0
    dirs = []

    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0

        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j)
        return count

    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or i == self.m or j == self.n or grid[i][j] == "0":
            return

        grid[i][j] = "0"

        for d in self.dirs:
            cr = i + d[0]
            cc = j + d[1]
            self.dfs(grid, cr, cc)

# BFS
# Time complexity : O(m * n)
# Space complexity : O(m * n)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No