Time complexity 0(MxN)
space complexity O(MXN)


class Solution_numIslands_DFS:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid)==0:
            return -1
        count=0
        m=len(grid)
        n=len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    self.dfs(grid,i,j)
                
        return count
    
    def dfs(self,grid,i,j):
        #base
        if(i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] !='1'):
            return
        #logic
        grid[i][j]='0'
        dirs=[[1,0 ],[0,1],[0,-1],[-1,0]]
        for dir in dirs:
            r=dir[0]+i
            c=dir[1]+j
            self.dfs(grid,r,c)
        