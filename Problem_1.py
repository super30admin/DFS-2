


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        self.grid = grid
        self.count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(i,j)
                    self.count += 1
        return self.count
        
    def dfs(self,i,j):
        self.grid[i][j] = '0'
        if 0<=i+1<len(self.grid) and self.grid[i+1][j] == '1':
            self.dfs(i+1,j)
        if 0<=i-1<len(self.grid) and self.grid[i-1][j] == '1':
            self.dfs(i-1,j)
        if 0<=j+1<len(self.grid[0]) and self.grid[i][j+1] == '1':
            self.dfs(i,j+1)
        if 0<=j-1<len(self.grid[0]) and self.grid[i][j-1] == '1':
            self.dfs(i,j-1)
            
    
