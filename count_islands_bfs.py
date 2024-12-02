#time-2(m*n), space-m*n
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        q= deque()
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    grid[i][j]='-1'
                    q.append((i,j))
                    while q:
                        curr=q.popleft()
                        for d in dirs:
                            x=curr[0]+d[0]
                            y=curr[1]+d[1]
                            if x>=0 and x<len(grid) and y>=0 and y<len(grid[0]) and grid[x][y]=='1':
                                grid[x][y]='-1'
                                q.append((x,y))
                    count+=1
        return count
                        
                        
        
        