class Solution:
#     tc==>O(N)
#      sc==>O(N)
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(grid,i,j,row,col):
            if i>=row or j>=col or i<0 or j<0:
                return
            if grid[i][j]=="2" or grid[i][j]=="0":
                return
            
            grid[i][j]="2"
            
            dfs(grid,i+1,j,row,col)
            dfs(grid,i-1,j,row,col)
            dfs(grid,i,j+1,row,col)
            dfs(grid,i,j-1,row,col)
            
            return              
            
        row = len(grid)
        col = len(grid[0])
        
        final = 0
        
        for i in range(row):
            for j in range(col):
                if grid[i][j]=="1":
                    dfs(grid,i,j,row,col)
                    final+=1
        
        return final