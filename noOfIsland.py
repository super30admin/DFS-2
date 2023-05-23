#TC: O(m*n)
#SC: O(1)

class Solution(object):

    def __init__(self):
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    def __dfs(self, grid, r, c, nRows, nCols):

        if (r < 0 or r >= nRows or c < 0 or c >= nCols or grid[r][c] == '0'):
            return

        grid[r][c] = '0'

        for direction in self.dirs:
            newRow = r + direction[0]
            newCol = c + direction[1]

            self.__dfs(grid, newRow, newCol, nRows, nCols)

    def numIslands(self, grid):
        
        if (grid == None or len(grid) == 0):
            return 0

        total = 0
        nRows = len(grid);  nCols = len(grid[0])

        for r in range(nRows):
            for c in range(nCols):
                if (grid[r][c] == '1'):
                    self.__dfs(grid, r, c, nRows, nCols)
                    total += 1

        return total