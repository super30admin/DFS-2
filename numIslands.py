#200. Number of Islands
# Time Complexity : O(m*n)
# Space Complexity :O(m*n) 
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        queue = []
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    queue.append([i,j])
                    count += 1
                    grid[i][j] = '0'
                    while queue:
                            curr = queue.pop(0)
                            for d in dirs:
                                r = d[0] + curr[0]
                                c = d[1] + curr[1]
                                if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
                                    grid[r][c] = '0'
                                    queue.append([r,c])
        return count
#200. Number of Islands
# Time Complexity : O(m*n)
# Space Complexity :O(m*n) 
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid,i,j)
        return count
    def dfs(self,grid,i,j):
        if i < 0 or j < 0 or i >= self.m or j >= self.n or grid[i][j] == '0':
            return
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        grid[i][j] = '0'
        for d in dirs:
            r = d[0] + i
            c = d[1] + j
            self.dfs(grid,r,c)