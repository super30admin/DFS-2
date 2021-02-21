# O(M * N) TIME AND O(M * N) SPACE WHERE M,N ARE ROWS AND COLS OF GRID 
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] != "0" and not visited[i][j]:
                    islands += 1
                    self.dfs(grid,i,j,visited)
        return islands
    
    def dfs(self,grid,i,j,visited):
        if grid[i][j] == "0" or visited[i][j]:
            return
        
        visited[i][j] = True
        
        for direction in [[-1,0],[0,-1],[1,0],[0,1]]:
            row = i + direction[0]
            col = j + direction[1]
            if row >= 0 and row < len(grid) and col >=0 and col < len(grid[0]) and not visited[row][col] and grid[row][col] == "1":
                self.dfs(grid,row,col,visited)
        
        
        