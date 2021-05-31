class Solution:
    def __init__(self):
        self.dirs = None
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return None
        
        self.dirs = ((0,1),(1,0),(0,-1),(-1,0))
        count = 0
        m = len(grid)
        n = len(grid[0])
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count+=1
                    self.dfs(grid, i, j, m, n)
                
        
        return count
    
    def dfs(self, grid, i, j, m, n):
        #base
        if i<0 or i==m or j<0 or j==n or grid[i][j] != '1':
            return

        grid[i][j] = '0'
        #logic
        for dir in self.dirs:
            r = dir[0]+i
            c = dir[1]+j
            self.dfs(grid, r,c,m,n)
            
# time complexity is o(n) and space complexity is min(r,c)
        
