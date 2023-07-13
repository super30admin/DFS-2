#Time Complexity:O(m*n)
#Space Complexity:O(m*n)

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        n=len(grid)
        m=len(grid[0])
        ans=0
        for i in range(n):
            for j in range(m):
                if grid[i][j]=='1':
                    
                    self.dfs(grid,i,j)
                    ans=ans+1
        return ans

    def dfs(self, grid, i, j):
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != '1':
            return
        grid[i][j] = '2'
        self.dfs(grid, i+1, j)
        self.dfs(grid, i-1, j)
        self.dfs(grid, i, j+1)
        self.dfs(grid, i, j-1)