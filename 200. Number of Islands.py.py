"""
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """
        Runtime Complexity : O(N)
        Space Complexity: O(N)
        
        
        Loop through every elem and find 1. If we found we traverse through all the four directions and make all ones are zeros.
        Then we return and repeat the whole process. For each repetation we increase the count by 1 and return the count
"""
        if grid == None : return ""
        island = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (grid[i][j] == '1'):
                    island += 1
                    self.isl(grid, i , j)
        return island
    def isl(self, grid, i , j):
        if ( i < 0 or i >= len(grid) or j< 0 or j >= len(grid[0]) or grid[i][j] == '0'): return
        grid[i][j] = '0'
        self.isl(grid, i+1, j)
        self.isl(grid, i-1 , j)
        self.isl(grid, i, j+1)
        self.isl(grid, i, j-1)