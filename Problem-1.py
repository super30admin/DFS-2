#Time Complexity :o(mn)
#Space Complexity :o(mn) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    m=None
    n=None
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if(grid==None):
            return 0
        
        self.m=len(grid)
        self.n=len(grid[0])
        ans=0
        
        for i in range(self.m):
            for j in range(self.n):
                if(grid[i][j]=='1'):
                    ans+=1
                    self.dfs(grid,i,j)

        return ans
    
    def dfs(self,grid,i,j):
        #base
        print(grid)
        if(i==self.m or i<0 or j==self.n or j>0 or grid[i][j]=='0'):
            return 
        
        #logic
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        grid[i][j]='0'
        for k in dirs:
            r=i+k[0]
            c=j+k[1]
            self.dfs(grid,r,c)
        
        
        