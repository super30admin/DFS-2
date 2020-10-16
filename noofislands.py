"""
// Time Complexity : O(M x N)
// Space Complexity : O(M x N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        output = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    output += 1
                    self.dfs(grid, i, j)
        print(grid)
        return output
        
        
    def dfs(self, grid, i, j):
        
        nrows = len(grid)
        ncols = len(grid[0])
        
        if(i < 0 or i >= nrows or j < 0 or j >= ncols or grid[i][j] != "1"):
            return
        
        grid[i][j] = "0"
        self.dfs(grid, i, j-1)
        self.dfs(grid, i, j+1)
        self.dfs(grid, i+1, j)        
        self.dfs(grid, i-1, j)        