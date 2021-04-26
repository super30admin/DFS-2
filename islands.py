# Time Complexity: O(mn) where m is the number of rows and n is the number of columns
# Space Complexity: O(mn) where m is the number of rows and n is the number of columns
# Ran on Leetcode: Yes

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        self.m = len(grid)
        self.n = len(grid[0])
        if not len(grid):
            return 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j)
                    count += 1
        return count
    
    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or i >= self.m or j >= self.n or grid[i][j] == "0":
            return
        grid[i][j] = "0"
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            self.dfs(grid, r, c)
        return
        
        