class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        #TC O(mn)
        #SC O(mn)
        if grid is None or len(grid) < 0:
            return 0
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        m = len(grid)
        n = len(grid[0])
        def dfs(grid, r, c):
            #base
            if r < 0 or r >= m or c < 0 or c< 0 or c >= n or c < 0 or grid[r][c] != '1':
                return
            
            #logic
            grid[r][c] = '0'
            for d in dirs:
                nr = r + d[0]
                nc = c + d[1]
                dfs(grid, nr, nc)
        island = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] =='1':
                    island += 1
                    dfs(grid, i, j)
        return island
                    
