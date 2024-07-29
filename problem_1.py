# Time O(M*N)
# Space O(1)
class Solution:
    def __init__(self):
        self.dirs = [[1,0], [-1,0], [0,1], [0,-1]]
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or grid[0] is None:
            return 0 
        m  = len(grid)
        n = len(grid[0])
     
        count = 0 
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j)
        return count 

    def dfs(self, grid, row, col):
        # base 
        if row < 0 or col >= len(grid[0]) or row >= len(grid) or col < 0 or grid[row][col] != '1':
            return 

        #logic
        grid[row][col] = '2'
        for dir in self.dirs:
            nr = dir[0] + row
            nc = dir[1] + col 
            self.dfs(grid, nr, nc)
        return

        