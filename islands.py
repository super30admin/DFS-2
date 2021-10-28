class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid)==0 or len(grid[0])==0:
            return 0
        n=len(grid)
        m=len(grid[0])
        count=0
        for i in range(n):
            for j in range(m):
                if grid[i][j]=='1':
                    self.dfs(grid,i,j,n,m)
                    count+=1
                                
        return count
    
    def dfs(self,grid,i,j,n,m):
        if i<0 or i>=n or j<0 or j>=m or grid[i][j]=='0':
            return
        grid[i][j]='0'
        self.dfs(grid,i-1,j,n,m)
        self.dfs(grid,i+1,j,n,m)
        self.dfs(grid,i,j-1,n,m)
        self.dfs(grid,i,j+1,n,m)
                

        
            
        