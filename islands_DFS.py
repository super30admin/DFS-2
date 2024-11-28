class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        direction_array = [(-1,0), (1,0), (0,1), (0,-1)]
        count = 0

        def dfs(i, j):
            for dx, dy in direction_array:
                nr = i + dx
                nc = j + dy

                if (0<=nr<m and 0<=nc<n and grid[nr][nc]=='1'):
                    grid[nr][nc] = '0'
                    dfs(nr,nc)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count = count + 1
                    grid[i][j] = '0'
                    dfs(i, j)
        
        return count
        
        
        