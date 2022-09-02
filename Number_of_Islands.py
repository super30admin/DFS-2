'''
Time complexity : O(m*n)
Space complexity : O(m*n)
'''


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    self.count += 1
                    self.helper(grid, i, j, m, n, dirs)
        return self.count

    def helper(self, grid, i, j, m, n, dirs):
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] != "1":
            return
        grid[i][j] = "-1"
        for d in dirs:
            nr = i + d[0]
            nc = j + d[1]
            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == "1":
                self.helper(grid, nr, nc, m, n, dirs)
