class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid==None and len(grid)==0:return 0
        self.m=len(grid)
        self.n=len(grid[0])
        self.dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        total=0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j]=='1':
                    self.dfs(grid,i,j)
                    total+=1
        return total
    def dfs(self,grid,r,c):
        if(r<0 or c<0 or r==self.m or c==self.n or grid[r][c]!='1'):return
        grid[r][c]='0'
        for dir1 in self.dirs:
            nr=r+dir1[0]
            nc=c+dir1[1]
            self.dfs(grid,nr,nc)
            