# Time Complexity : O(RxC) (where R is number of rows and C is number of columns in grid)
# Space Complexity : O(RxC) (where R is number of rows and C is number of columns in grid)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Run through each cell of grid and If its is island cell than call helper function and increments iceland count by 1.
# - In helper funciton change current cells's value to something different than water and Island's cell value.
# - Check for its valid neighbour and if it is island cell call helper function on that cell.
# Here In the main for loop we will not encounter same islands cell again because we already flipped it to something else.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
#       Covering corner case
        if not grid:
            return 0
#       Calculating rows and columns
        rows = len(grid)
        cols = len(grid[0])
        islands = 0
#       Iterarte through each cell of the grid.
        for i in range(rows):
            for j in range(cols):
#               Check if the cell is island cell
                if grid[i][j] == '1':
#                   call helper funciton on current cell
                    self.flipIslands(grid, i, j, rows, cols)
#                   Increment the island count
                    islands += 1
        return islands
                    
    def flipIslands(self, grid, r, c, maxr, maxc):
#         Here water is '0' and island is '1' so change it other than these two values. I choose '2' here.
        grid[r][c] = '2'
#       Check all four neighbour
        for nr, nc in [(r, c+1), (r, c-1), (r-1, c), (r+1, c)]:
#           Check that neighbour is not out of bound and it is island cell
            if 0 <= nr < maxr and 0 <= nc < maxc and grid[nr][nc] == '1':
#               Call helper funiton on this neighbour
                self.flipIslands(grid, nr, nc, maxr, maxc)
                    
        
