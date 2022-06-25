#Time complexity : O(m*n)
#Space complexity: O(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        cnt = 0
        if not grid or not len(grid):
            return 0
        
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    cnt += 1
                    self.dfs(grid, i, j, m, n, dirs)
                    
        return cnt
    
    def dfs(self, grid, i, j, m, n, dirs):
        
        #base
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == "0":
            return 
        
        grid[i][j] = "0"
        
        for d in dirs:
            nr = i + d[0]
            nc = j + d[1]
            self.dfs(grid, nr, nc, m, n, dirs)
