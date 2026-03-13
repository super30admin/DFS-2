# 200. Number of Islands
# https://leetcode.com/problems/number-of-islands/

# T.C: O(n
# S.C: O(n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        neighbors = [[0,1],[0,-1],[1,0],[-1,0]]
        m,n = len(grid), len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    self.dfs(i,j,grid,m,n, neighbors)
                    count += 1
        return count

        
    def dfs(self, i, j, grid,m,n, neighbors):
        grid[i][j] = "0"
        for el in neighbors:
            r,c = el[0] + i, el[1] + j
            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == "1":
                self.dfs(r,c,grid,m,n, neighbors)