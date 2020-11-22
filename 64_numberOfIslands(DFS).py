# accepted on leetcode(200)
# time - O(M*N), space - O(1)

class Solution:
    def numIslands(self, grid) -> int:
        # Edge case
        if len(grid) == 0 or not grid: return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        # iterate through the grid and if we found 1 then increment the count and by using dfs approach check for nearest 1's and make them 0.
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)
        return count

    def dfs(self, grid, i, j):
        # base case
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0': return
        # directions array
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        grid[i][j] = '0'
        # iterate through the directions array and move in all four directions and check for 1.
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j
            self.dfs(grid, r, c)