class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid==None or len(grid)==0:
            return 0
        
        #taking the rows and cols
        m=len(grid)
        n=len(grid[0])
        directions=[[-1,0],[1,0],[0,-1],[0,1]]
        count=0
        
        #DFS approach
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    self.dfs(grid,i,j,m,n,directions)
        
        return count
                    
    
    def dfs(self,grid,i,j,m,n,directions):
        #base
        if (i<0 or j <0 or i==m or j==n or grid[i][j]=="0"):
            return
        
        
        #logic
        grid[i][j]="0"
        #Going to all the directions and calling dfs on every change
        for d in directions:
            r=i+d[0]
            c=j+d[1]
            self.dfs(grid,r,c,m,n,directions)