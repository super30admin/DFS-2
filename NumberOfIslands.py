# Time Complexity : O(m*n)
# Space Complexity : O(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count

    def dfs(self, grid, sr, sc):
        # base
        if sr < 0 or sc < 0 or sr == len(grid) or sc == len(grid[0]) or grid[sr][sc] == '0':
            return
        # logic
        grid[sr][sc] = '0'
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for d in dirs:
            r = d[0] + sr
            c = d[1] + sc
            self.dfs(grid, r, c)