# Time Complexity : O(2m*n)~ O(m*n)
# Space Complexity : O(min(m,n)) as maximum breadth will be diagonal
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        q=deque()
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count+=1
                    q.append((i,j))
                    grid[i][j]='0'
                    while q:
                        curr=q.popleft()
                        for dir in dirs:
                            nr=dir[0]+curr[0]
                            nc=dir[1]+curr[1]
                            if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]=='1':
                                q.append((nr,nc))
                                grid[nr][nc]='0'
        return count



                        
