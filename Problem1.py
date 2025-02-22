# Problem 1 : Number of Islands
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # if the grid is empty
        if not grid:
            return 0
        # length of grid row and grid column
        rows, cols = len(grid), len(grid[0])
        # variable of number of column
        islands = 0

        # dfs traverse function
        def dfs(r: int, c:int) -> None:
            # direction array
            directions = [(1,0),(-1,0),(0,1),(0,-1)]
            # mark the position as 0 i.e visited
            grid[r][c] = '0'
            # loop through direction
            for dr, dc in directions:
                # neighbouring row and column
                row = r + dr
                col = c + dc
                # check the boundary condition and if the neighbour cell is land then call dfs for that cell
                if ( 0 <= row < rows and 0 <= col < cols and grid[row][col] == '1'):
                    dfs(row, col)

        # loop through matrix
        for r in range(rows):
            for c in range(cols):
                # if the cell is land then call dfs for the cell
                if (grid[r][c] == '1'):
                    dfs(r,c)
                    # increment the count of island
                    islands += 1

        return islands