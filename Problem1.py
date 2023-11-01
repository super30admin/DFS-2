'''
1. If we find an island we increment the count and then dfs on all the neighbours of that island
2. Before dfs we mark the island as visited by changing the value from 1 to -1

TC: O(m*n)
SC: O(m*n)
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid or len(grid) == 0:
            return 0

        #DFS
        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        total = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    total += 1
                    self.dfs(grid,i,j)

        return total
    
    def dfs(self, grid : List[List[str]], row: int, col: int) -> None:
        if row < 0 or row == self.m or col < 0 or col == self.n or grid[row][col] != '1':
            return
        
        grid[row][col] = '-1'
        for Dir in self.dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            self.dfs(grid,nr,nc)
        

        