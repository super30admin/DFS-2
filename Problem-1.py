"""
# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:

11110

11010

11000

00000

Output: 1
Example 2:

Input:

11000

11000

00100

00011

Output: 3


Time - O(mn)
Space- O(mn)
"""


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:    # null case
            return 0
        m = len(grid)       #rows
        n = len(grid[0])    #cols
        count = 0         # to keep count of islands
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':      #when we found first 1 we go into dfs recursion
                    self.dfs(grid, m, n, i, j)
                    count += 1
        return count

    def dfs(self, grid, m, n, i, j):                     #dfs with directiosn array, if we found 1 in any of four direction go into recursion
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        grid[i][j] = '0'
        for direct in directions:
            r = i + direct[0]
            c = j + direct[1]
            if r < m and r >= 0 and c < n and c >= 0 and grid[r][c] == '1':
                self.dfs(grid, m, n, r, c)






