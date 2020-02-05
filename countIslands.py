"""
Time Complexity : numIslands_bfs() - O(mn)
                  numIslands_dfs() - O(mn)
Space Complexity : numIslands_bfs() - O(min(m, n))
                  numIslands_dfs() - O(1)   [O(mn) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""
from queue import Queue

class Solution:
    dirs = [[-1,0], [1,0], [0,-1], [0,1]]
    numsOfIsland = 0
    
    def numIslands_bfs(self, grid):
        m = len(grid)
        if not grid or m == 0:
            return 0
        n = len(grid[0])
    
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    self.numsOfIsland += 1
                    self.bfs(grid, i, j, m, n)
                    
        return self.numsOfIsland
        
        
    def bfs(self, grid, i, j, m, n):
        q = Queue()
        
        grid[i][j] = "0"
        q.put([i, j])
        
        while not q.empty():
            curr = q.get()
            for d in self.dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == "1":
                    grid[r][c] = "0"
                    q.put([r, c])
                    
        return
    
    def numIslands_dfs(self, grid):
        m = len(grid)
        n = len(grid[0])
        if not grid or m == 0:
            return 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    self.numsOfIsland += 1
                    self.dfs(grid, i, j, m, n)
                    
        return self.numsOfIsland
        
        
    def dfs(self, grid, i , j, m, n):
        if grid[i][j] == "1":
            grid[i][j] = "0"
        
        for d in self.dirs:
            r = i + d[0]
            c = j + d[1]
            
            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == "1":
                self.dfs(grid, r, c, m, n)
                
        return
                
s = Solution()
print(s.numIslands_bfs([["1","1","1","1","0"],
                    ["1","1","0","1","0"],
                    ["1","1","0","0","0"],
                    ["0","0","0","0","0"]]))