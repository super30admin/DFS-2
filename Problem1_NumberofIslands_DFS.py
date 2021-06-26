'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 200. Number of Islands

# Given an m x n 2D binary grid grid which represents a map of '1's 
# (land) and '0's (water), return the number of islands.

# An island is surrounded by water and is formed by connecting 
# adjacent lands horizontally or vertically. You may assume all four
#  edges of the grid are all surrounded by water.


#-----------------
# Time Complexity: 
#-----------------
# O(M * N) - Need to process M rows and N columns in every case
#------------------
# Space Complexity: 
#------------------
# O(M * N): Max size of dfs stack is M*N elements

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

import collections
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 :
            return 0
        
        m = len(grid)
        n = len(grid[0])
        
        self.dirs = [[0,1], [1,0], [0, -1], [-1,0]] #right, down, left, up
        
        count = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count+= 1
                    self.dfs(grid, i, j, m, n)
        return count
    
    def dfs(self, grid: List[List[str]], row, col, m, n):
        
        if row < 0 or col <0 or row == m or col == n or grid[row][col] != "1":
            return
        
        grid[row][col] = "0"
        
        for direction in self.dirs:
            neighbor_row = direction[0] + row
            neighbor_col = direction[1] + col
            self.dfs(grid, neighbor_row, neighbor_col, m, n)