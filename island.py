#BFS To maintain visited nodes will change value 1 to 2 and change all connected 1's around it,
# then again diffrent 1 is encountered will incremanet island cound and change all connected and so on
#Time Complexity O(MN) + O(MN) M= rows, N=columns of grod
#Space Complexity  O(Min(MN)) 
#It successfully runs on leetcode   
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        q = deque()
        r = len(grid)
        c = len(grid[0])
        d = {(0,1), (0,-1), (1,0), (-1,0)}
        island = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j]=='1':
                    island+=1
                    q.append((i,j))
                    grid[i][j]='2'
                    while q:
                        m,n = q.popleft()
                        for x,y in d:
                            nr,nc= m+x, n+y
                            if nr>=0 and nc>=0 and nr<r and nc<c and grid[nr][nc]=='1': 
                                q.append((nr,nc))
                                grid[nr][nc]="2"
      
        return island

#DFS
#Time Complexity O(MN) + O(MN) M= rows, N=columns of grod
#Space Complexity  O(MN) 
#It successfully runs on leetcode 
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        r = len(grid)
        c = len(grid[0])
        d = {(0,1), (0,-1), (1,0), (-1,0)}
        self.island = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j]=="1":
                    self.island+=1
                    self.dfs(grid,i,j,r,c,d)
        return self.island
    
    def dfs(self,grid,i,j,r,c,d):
        if i<0 or j<0 or i==r or j==c or grid[i][j]!="1": return
        grid[i][j]="2"    
        for x,y in d:
            nr,nc= i+x, j+y
            self.dfs(grid,nr,nc,r,c,d)