# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
class Solution:
    dirs = list()
    count = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        m = len(grid) 
        n = len(grid[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.count += 1
                    self.dfs(grid, i,j,m,n)
        return self.count
        
    def dfs(self, grid, i,j,m,n):
        
        # base
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] !='1':
            return
        # logic
        grid[i][j] = '0'
        for direction in self.dirs:
            r = i + direction[0]
            c = j + direction[1]
            self.dfs(grid, r,c,m,n)
            
        
        