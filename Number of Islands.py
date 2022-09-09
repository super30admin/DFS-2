# TC : O(mn)
# SC : O(mn)
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        self.dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        self.grid = grid
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        for i in range(self.m):
            for j in range(self.n):                
                if grid[i][j]=="1":
                    count+=1
                    self.dfs(i,j)
                    
              
        return count
                
        
        
    def dfs(self,r,c):
        #base
        #boundry check
        # zero check - end of island
        if r < 0 or r==self.m or c<0 or c==self.n or self.grid[r][c]=="0":
            return 
        
        #logic        
        self.grid[r][c]= "0"
        for dx,dy in self.dirs:
            nr = dx+r
            nc = dy+c            
            self.dfs(nr,nc)