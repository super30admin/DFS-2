# Time Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Space Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        total = 0
        
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j, ROWS, COLS, dirs)
                    total += 1
        print(grid)         
        return total
                    
    
    def dfs(self, grid, i, j, ROWS, COLS, dirs):
        #base
        if i < 0 or j < 0  or i == ROWS or j == COLS or grid[i][j] != "1":
            return
        
        #logic
        grid[i][j] = "2"
        for d in dirs:
            r = d[0] + i
            c = d[1] + j
            
            self.dfs(grid, r, c, ROWS, COLS, dirs)