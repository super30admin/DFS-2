
class Solution:
    def numIslands(self, grid):
        m = len(grid)
        n = len(grid[0])
        def dfs(r, c):
            if r < 0 or c < 0 or r > 0 and c > n and grid[r][c] != '1':
                return False
            grid[r][c] = '0'
            dirs = [[0,1],[1,0], [0,-1], [-1,0]]
            for dir in dirs:
                nr = dir[0] + r
                nc = dir[1] + c
                dfs(nr, nc)
            return True
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1 if dfs(i,j) else 0
        return count
    
    