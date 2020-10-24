# O(M * N) TIME AND O(M * N) SPACE WHERE M,N ARE ROWS AND COLS OF GRID
class Solution:
    def __init__(self):
        self.count = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        grid = [[int(grid[i][j]) for j in range(len(grid[0]))] for i in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    self.count += 1
                    self.dfs(grid,i,j)
        return self.count
    
    def dfs(self,grid,i,j):
        if grid[i][j] != 1:
            return
        grid[i][j] = 2
        neighbours = self.getNeighbours(grid,i,j)
        for r,c in neighbours:
            self.dfs(grid,r,c)
    
    def getNeighbours(self,grid,i,j):
        neighbours = []
        for r,c in [(i,j+1),(i+1,j),(i,j-1),(i-1,j)]:
            if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == 1:
                neighbours.append((r,c))
        return neighbours
                