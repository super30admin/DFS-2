#Time Complexity :O(m*n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes
def dfs(self, row, col, grid, rows, cols):
        if row<0 or row>=rows or col<0 or col>=cols or grid[row][col] != '1':
            return 
        if grid[row][col] == '1':
            grid[row][col] = '2'
            self.dfs(row-1, col, grid,  rows, cols)
            self.dfs(row, col-1, grid, rows, cols)
            self.dfs(row+1, col, grid, rows, cols)
            self.dfs(row, col+1, grid, rows, cols)
            
        return 
def numIslands(self, grid: List[List[str]]) -> int:
        numIslands = 0
        m = len(grid)
        n = len(grid[0])
        
        for i in range (m):
            for j in range(n):
                if grid[i][j] == '1':
                    numIslands += 1
                    self.dfs(i, j, grid, m , n)
        return numIslands