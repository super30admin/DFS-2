#time-m*n,space-m*n
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
               
                if grid[i][j]=='1':
                    print(i,j)
                    self.dfs(grid,i,j)
                    count+=1
        return count
                    
    def dfs(self,grid,x,y):
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        #base
       
        #logic
        grid[x][y]='-1'
        for i in dirs:
            nx=x+i[0]
            ny=y+i[1]
            if nx>=0 and nx<len(grid) and ny>=0 and ny<len(grid[0]) and grid[nx][ny]=='1':
                self.dfs(grid,nx,ny)
        