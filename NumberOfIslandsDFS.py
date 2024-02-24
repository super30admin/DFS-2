'''
TC: O(m*n)
SC: O()
'''
from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        count = 0

        def dfs(nx,ny,grid):
            if nx<0 or ny<0 or nx>=ROWS or ny>=COLS or grid[nx][ny] == '0':
                return
            grid[nx][ny] = '0'
            dfs(nx+1,ny,grid)
            dfs(nx-1,ny,grid)
            dfs(nx,ny+1,grid)
            dfs(nx,ny-1,grid)

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == '1':
                    count += 1
                    dfs(i,j,grid)
        return count
s = Solution()
print(s.numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
print(s.numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]))