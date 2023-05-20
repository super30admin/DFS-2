## Problem1 (https://leetcode.com/problems/number-of-islands/)

# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: Yes
# Approach: DFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        result = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    result += 1
                    self.dfs(grid, i, j, m, n, dirs)
        return result

    def dfs(self, grid, r, c, m, n, dirs):
        # base
        if r < 0 or r == m or c < 0 or c == n or grid[r][c] == '0':
            return

        # logic
        grid[r][c] = '0'
        for d in dirs:
            nr = r + d[0]
            nc = c + d[1]
            self.dfs(grid, nr, nc, m, n, dirs)