# // Time Complexity : O(nm)
# // Space Complexity : 0(nm) 
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO

class Solution(object):
   
    def dfs(self , grid , i , j ):
        
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] == "0": 
            return
        else : 
            grid[i][j] = "0"
            self.dfs(grid , i-1,j)
            self.dfs(grid , i+1,j)
            self.dfs(grid , i,j+1)
            self.dfs(grid , i,j-1)
            
            
    
    def numIslands(self, grid):
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]== "1": 
                    islands += 1
                    self.dfs(grid , i , j)
        return islands