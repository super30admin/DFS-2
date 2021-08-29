"""
Time Complexity : O(mxn) m is no. of rows and n is no. of cols
Space Complexity : O(mxn) m is no. of rows and n is no. of cols
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0:
            return grid
        count = 0
        m = len(grid)
        n = len(grid[0])
        self.dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        # Traverse through the matrix to find '1' and then when we find it do a BFS
        # and count the number of times we carry out BFS that woul dbe the no. of
        # islands
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)
        return count
    def dfs(self, grid, row, col):
        # Base
        if row < 0 or col < 0 or row == len(grid) or col == len(grid[0]) or grid[row][col] != '1':
            return
        # Logic
        grid[row][col] = '0'
        for item in self.dirs:
            nr = row + item[0]
            nc = col + item[1]
            self.dfs(grid, nr, nc)