#Time Complexity : O(M*N)
#Space Complexity : O(M*N)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
          #USING DFS
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.dfs(i,j,grid)
                    islands += 1
        return islands
        
    def dfs(self, row, col, grid):
        
        if(row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and grid[row][col] == "1"):
            grid[row][col] = "2"
            
        else:
            return
        
        self.dfs(row+1,col, grid)
        self.dfs(row, col+1, grid)
        self.dfs(row-1, col, grid)
        self.dfs(row, col-1, grid)
