# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""
 *** BFS Approach ***
 Time Complexity : O(2mn) ~ O(mn)
 Space Complexity : O(min(m,n))
"""
from collections import deque
class Solution:   
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid: return 0
        m = len(grid)
        n = len(grid[0])  
        q = deque()
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        islands = 0
                
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    q.append((i,j))
                    islands += 1
                    grid[i][j] = "0"
                       
                while q:
                    elem = q.popleft()
                    
                    for d in dirs:
                        row = d[0] + elem[0]
                        col = d[1] + elem[1]
                        if (row<m and col<n and row>=0 and col>=0) and (grid[row][col]=="1"):
                            q.append((row, col))
                            grid[row][col] = "0"
                    
        return islands

"""
 *** DFS Approach ***
 Time Complexity : O(m*n)
 Space Complexity : O(m*n)
"""
class Solution:   
    m = 0
    n = 0
    dirs = [[0,1], [0,-1], [1,0], [-1,0]]
    islands = 0
    
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid: return 0
        self.m = len(grid)
        self.n = len(grid[0])        
                
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.islands += 1
                    self.dfs(grid, i, j)
        
        return self.islands
                    
    def dfs(self, grid, r, c):
        # Base
        if (r>=self.m or c>=self.n or r<0 or c<0) or (grid[r][c]=="0"): return       
        
        # Logic
        grid[r][c] = "0"
        for d in self.dirs:
            row = d[0] + r
            col = d[1] + c
            # No need to check again since u already checked in base condition
            self.dfs(grid, row, col) 
                    