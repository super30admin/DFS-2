class Solution(object):
    directions = [[0, 1],[0, -1],[1, 0],[-1, 0]]
    
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if(grid == None or len(grid) == 0 or len(grid[0]) == 0):
            return 0
        
        n = len(grid)
        m = len(grid[0])
        island = 0
        
        for i in range(0, n):
            for j in range(0, m):
                if grid[i][j] == "1":
                    self.recurr(grid, i, j)
                    island += 1
        
        return island
    
    def recurr(self, grid, x, y):
        grid[x][y] = "0"
        
        for dirs in self.directions:
            r = x + dirs[0]
            c = y + dirs[1]
            
            if(r >=0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == "1"):
                self.recurr(grid, r, c)
