"""

    Name : Shahreen Shahjahan Psyche
    Time : O(M * N)
    Space : O(M * N)

    This code ran successfully for all the test cases in Leetcode.

"""

from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        
        from collections import deque
        
        q = deque()
        num_islands = 0
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):  
                if grid[i][j] == '1':
                    num_islands += 1
                    q.append((i, j))
                    grid[i][j] = '0'
                    while q:
                        curr = q.popleft()
                        for k in dirs:
                            pos_i = curr[0] + k[0]
                            pos_j = curr[1] + k[1]
                            if pos_i > -1 and pos_i < len(grid) and pos_j > -1 and pos_j < len(grid[0]):
                                if grid[pos_i][pos_j] == '1':
                                    grid[pos_i][pos_j] = '0'
                                    q.append((pos_i, pos_j))
                    
        
        
        return num_islands