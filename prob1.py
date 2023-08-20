# Time Complexity : O(mn)
# Space Complexity :O(mn)
# Passed on Leetcode: yes

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(grid, i, j):
            #base
            if (i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == '0'):
                return
            #logic
            grid[i][j] = '0'
            for direc in [[1,0], [0,1], [-1,0], [0,-1]]:
                nr = direc[0] + i
                nc = direc[1] + j
                dfs(grid, nr, nc)
            return

        
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    dfs(grid, i, j)

        return count