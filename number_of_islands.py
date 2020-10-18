"""
Solution: DFS recursive approach using stack
Leetcode: https://leetcode.com/problems/number-of-islands/
Time Complexity: O(m*n), m rows and n columns, as the grid is traversed only once
Space Complexity: O(m*n), as stack would store all values in worst case
"""


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        nrows = len(grid)
        ncols = len(grid[0])
        numsIslands = 0

        # base case
        if grid is None or nrows is 0 or ncols is 0:
            return 0

        # Traverse the grid
        for i in range(nrows):
            for j in range(ncols):
                # call dfs recursive function only when value is 1
                if grid[i][j] == '1':
                    numsIslands += 1
                    self.dfs_helper(grid, i, j, nrows, ncols)

        return numsIslands

    # this function checks values top, down, left, right of row/col recursively and changes 1 to 0 after visit
    def dfs_helper(self, grid, row, col, nrows, ncols):
        grid[row][col] = '0'
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        for dire in dirs:
            new_row = row + dire[0]
            new_col = col + dire[1]
            # checking the valid directions
            if 0 <= new_row < nrows and 0 <= new_col < ncols and grid[new_row][new_col] == '1':
                self.dfs_helper(grid, new_row, new_col, nrows, ncols)