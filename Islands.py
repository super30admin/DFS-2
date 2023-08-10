# Time Complexity :BFS= O(M*N) DFS= O(M*N)
# Space Complexity :DFS= O(1) BFS= O(M*N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



# BFS
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        q=deque([])
        c=0
        directions=[(-1,0),(0,-1),(1,0),(0,1)]
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=='1'):
                    # q=deque([])
                    q.append((i,j))
                    grid[i][j]=0
                    c+=1
                    while(len(q)):
                        curr=q.popleft()
                        for d in directions:
                            nr=curr[0]+d[0]
                            nc=curr[1]+d[1]
                            if(nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]=='1'):
                                q.append((nr,nc))
                                grid[nr][nc]=0
        return c
    
    # DFS
    class Solution:
    def dfs(self, grid, i, j):
        # base
        if(i<0 or i>=len(grid) or j<0 or j>=len(grid[0])):
            return 
        # logic
        print(i,j)
        if(grid[i][j]=='1'):
            grid[i][j]=0
        else:
            return
        self.dfs(grid, i-1, j) # top
        self.dfs(grid, i, j-1) # left
        self.dfs(grid, i+1, j) # down
        self.dfs(grid, i, j+1) # right


    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        print(m,n)
        q=deque([])
        c=0
        directions=[(-1,0),(0,-1),(1,0),(0,1)]
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=='1'):
                    c+=1
                    # grid[i][j]=0
                    self.dfs(grid, i, j)