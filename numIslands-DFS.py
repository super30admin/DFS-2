#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if grid is None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        dirs =[[-1, 0], [1, 0], [0, -1], [0, 1]]
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j, m, n, dirs)
        
        return count
        
    def dfs(self, grid, i, j, m, n, dirs):
        if i < 0 or j < 0 or i == m or j == n or grid[i][j] == '0':
            return
        
        grid[i][j] = '0'
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            self.dfs(grid, r, c, m, n, dirs)