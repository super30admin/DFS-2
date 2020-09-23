# Time Complexity : O(n * m)
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        if not grid:
            return islands
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.s_island(i, j, grid)
                    islands+=1
        return islands
    
    def s_island(self, i, j, grid):
        if i < 0 or j< 0 or i==len(grid) or j==len(grid[0]) or grid[i][j] == '0':
            return
        
        grid[i][j] = '0'
        
        self.s_island(i, j+1, grid)
        self.s_island(i, j-1, grid)
        self.s_island(i+1, j, grid)
        self.s_island(i-1, j, grid)
        
                    