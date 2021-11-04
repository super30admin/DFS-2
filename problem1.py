#Time complexity O(n*m), space O(1)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        
        c=0
  #Traversing to see if grid has land and then calling dfs and incrementing count if we found land      
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                
                if grid[i][j]=='1':
                    self.dfs(grid,i,j)
                    c+=1
                    
                  
        return c
    
 #Dfs for checking in all the 4 directions whether we have land   
    def dfs(self,grid,i,j):
        
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]) or grid[i][j]!='1':
            return 
        
        grid[i][j] ='0'
        
        self.dfs(grid,i-1,j)
        self.dfs(grid,i+1,j)
        self.dfs(grid,i,j-1)
        self.dfs(grid,i,j+1)
