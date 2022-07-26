class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        
        visited=set()
        directions=[(0,-1),(0,1),(-1,0),(1,0)]
        self.count=0
        
        def dfs(r,c):
            
            if r<0 or c<0 or r>=m or c>=n or grid[r][c]=='0':
                return
            
            grid[r][c]='0'
            
            dfs(r-1,c)
            dfs(r+1,c)
            dfs(r,c-1)
            dfs(r,c+1)
        
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    self.count+=1
                    dfs(i,j)
                
        return self.count
            
        