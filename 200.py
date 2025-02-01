# Time Complexity : O(m*n) touching cells but not restarting it.
# Soace complexity : O(m + n)
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or grid == None:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]

        def dfs(grid, row, col):
            if row == m or row < 0 or col == n or col < 0 or grid[row][col] != "1":
                return 
                
            grid[row][col] = "2"
            for dir1 in dirs:
                nr = row + dir1[0]
                nc = col + dir1[1]
                dfs(grid, nr, nc)


        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1" :
                    count = count + 1
                    dfs(grid, i, j)
                    
        return count