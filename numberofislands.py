



"""Number of Islands
time Complexity : O(2mn)
Space Complexity: O(mn)
Approach dfs"""

class Solution:
    def dfs(self,grid,i,j,dirs):
        #base
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]) or grid[i][j] != "1":
            return 
        #logic
        grid[i][j]=0
        for d in dirs:
            r = d[0]+i
            c = d[1]+j
            self.dfs(grid,r,c,dirs)
        
    
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        count = 0
        if grid== None and len(grid)==0 and grid[0]==None and len(grid[0])==0:
            return count
        
        dirs = [[1,0],[0,1],[0,-1],[-1,0]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] =="1":
                    count+=1
                    self.dfs(grid,i,j,dirs)
        return count
        
        