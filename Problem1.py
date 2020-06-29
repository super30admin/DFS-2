"""
// Time Complexity : o(m*n)
// Space Complexity : o(m*n), when all values are 1 in the matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def dfs(self, grid, r, c):
        #base
        if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] != "1":
            return 
        #logic
        
        grid[r][c] = "0" #change cell to 0
        
        dirs = [[1,0],[-1,0],[0,1],[0,-1]] # for neighbours in all directions
        
        for d in dirs:
            row = r + d[0]
            col = c + d[1]
            self.dfs(grid,row,col)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        
        count = 0
        
        for i in range(rows): #iterate over entire matrix
            for j in range(cols):
                
                if grid[i][j] == "1": # if we find a 1, use dfs to find all the neighbouring 1's and change them to 0 as they will be part of the same island
                    count += 1 #increase count of island
                    self.dfs(grid, i,j)
                    
        return count
                    