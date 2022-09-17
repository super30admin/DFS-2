#BFS
import collections
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirlist=[[1,0],[0,1],[-1,0],[0,-1]]
        queue=collections.deque()
        m=len(grid)
        n=len(grid[0])
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    queue.append([i,j])
                    grid[i][j]="0"
                    while queue:
                        curr=queue.popleft()
                        for d in dirlist:
                            nr=curr[0]+d[0]
                            nc=curr[1]+d[1]
                            if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]=="1":
                                queue.append([nr,nc])
                                grid[nr][nc]="0"
        return count

#DFS
class Solution:
    count=0
    dir=[[0,1],[1,0],[0,-1],[-1,0]]
    def dfs(self,grid,i,j):
        for d in self.dir:
            nr=i+d[0]
            nc=j+d[1]
            if nr>=0 and nc>=0 and nr<len(grid) and nc<len(grid[0]) and grid[nr][nc]=="1":
                grid[nr][nc]="0"
                self.dfs(grid,nr,nc)
        
        
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    self.count+=1
                    grid[i][j]="0"
                    self.dfs(grid,i,j)
        return self.count
