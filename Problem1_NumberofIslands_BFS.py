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
# O(min(M, N)): Max size of queue is min(M, N) elements

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

import collections
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 :
            return 0
        
        queue = collections.deque()
        m = len(grid)
        n = len(grid[0])
        
        dirs = [[0,1], [1,0], [0, -1], [-1,0]] #right, down, left, up
        
        count = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    #bfs
                    queue.append([i, j])
                    while len(queue) > 0:
                        curr = queue.popleft()
                        curr_row = curr[0]
                        curr_col = curr[1]
                        for direction in dirs:
                            neighbor_row = curr_row + direction[0]
                            neighbor_col = curr_col + direction[1]
                            
                            if neighbor_row >= 0 and neighbor_col >= 0 and neighbor_row < m and neighbor_col < n and grid[neighbor_row][neighbor_col] == "1":
                                queue.append([neighbor_row, neighbor_col])
                                grid[neighbor_row][neighbor_col] = "0"
        return count