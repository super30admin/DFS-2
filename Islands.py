'''
Solution
1.  To count the number of valid islands, perform DFS on those cells containing a 1, for each cell perform DFS
    and keep track of the count if it is a valid island.
2.  While performing DFS on a cell, make sure you don't visit the parent cell again by making the cell to 0.
3.  Traverse all directions and perform DFS in each direction if it is a valid cell.

Time Complexity:    O(rows x columns)   |   Space Complexity:   O(1)

--- Passed all testcases successfully on Leetcode.
'''


class Islands_Recursion(object):

    def __init__(self):
        #   initialize directions array
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    def __dfs(self, grid, r, c, nRows, nCols):

        #   base case -- checking validity
        if (r < 0 or r >= nRows or c < 0 or c >= nCols or grid[r][c] == '0'):
            return

        #   make sure you don't visit the parent cell again by making the cell to 0
        grid[r][c] = '0'

        #   traverse all directions and perform DFS in each direction if it is a valid cell
        for direction in self.dirs:
            newRow = r + direction[0]
            newCol = c + direction[1]

            self.__dfs(grid, newRow, newCol, nRows, nCols)

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        #   edge case check
        if (grid == None or len(grid) == 0):
            return 0

        #   initialize the count, number of rows and number of columns
        total = 0
        nRows = len(grid);  nCols = len(grid[0])

        #   for each cell perform DFS and keep track of the count if it is a valid island.
        for r in range(nRows):
            for c in range(nCols):
                if (grid[r][c] == '1'):
                    self.__dfs(grid, r, c, nRows, nCols)
                    total += 1

        #   return the count
        return total